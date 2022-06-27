package com.example.searchmovie.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.searchmovie.R;
import com.example.searchmovie.adapters.TVShowsAdapter;
import com.example.searchmovie.databinding.ActivitySearchBinding;
import com.example.searchmovie.models.TVshow;
import com.example.searchmovie.viewmodels.SearchViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SearchActivity extends AppCompatActivity  {

    private ActivitySearchBinding activitySearchBinding;
    private SearchViewModel viewModel;
    private List<TVshow> tVshows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;
    private int currentPage = 1;
    private int totalAvailablePages = 1;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = DataBindingUtil.setContentView(this,R.layout.activity_search);
        doInitialization();
    }
    private void doInitialization(){
        activitySearchBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        activitySearchBinding.tvShowsRecyclerview.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        //*
        tvShowsAdapter = new TVShowsAdapter(tVshows);
        activitySearchBinding.tvShowsRecyclerview.setAdapter(tvShowsAdapter);

        activitySearchBinding.inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(timer!=null){
                    timer.cancel();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().trim().isEmpty()){
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    currentPage = 1;
                                    totalAvailablePages = 1;
                                    searchTVShow(editable.toString());
                                }
                            });
                        }
                    },800);
                }else{
                    tVshows.clear();
                    tvShowsAdapter.notifyDataSetChanged();
                }
            }
        });

        activitySearchBinding.tvShowsRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!activitySearchBinding.tvShowsRecyclerview.canScrollVertically(1)){
                    if(!activitySearchBinding.inputSearch.getText().toString().isEmpty()){
                        if(currentPage<totalAvailablePages){
                            currentPage+=1;
                            searchTVShow(activitySearchBinding.inputSearch.getText().toString());
                        }
                    }
                }
            }
        });
        activitySearchBinding.inputSearch.requestFocus();
    }

    private void searchTVShow(String query){
        toggleLoading();
        viewModel.searchTVShow(query,currentPage).observe(this,tvShowResponse -> {
            toggleLoading();
            if(tvShowResponse!=null){
                totalAvailablePages = tvShowResponse.getTotalpages();
                if(tvShowResponse.gettVshows()!=null){
                    int oldCount  = tVshows.size();
                    tVshows.addAll(tvShowResponse.gettVshows());
                    tvShowsAdapter.notifyItemRangeInserted(oldCount,tVshows.size());
                }
            }
        });
    }

    private void toggleLoading() {
        if (currentPage == 1) {
            if (activitySearchBinding.getIsLoading() != null && activitySearchBinding.getIsLoading()) {
                activitySearchBinding.setIsLoading(false);
            } else {
                activitySearchBinding.setIsLoading(true);
            }
        } else {
            if (activitySearchBinding.getIsLoadingMore() != null &&activitySearchBinding.getIsLoadingMore()) {
                activitySearchBinding.setIsLoadingMore(false);
            } else {
                activitySearchBinding.setIsLoadingMore(true);
            }
        }
    }


}