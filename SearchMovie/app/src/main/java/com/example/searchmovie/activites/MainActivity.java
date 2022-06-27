package com.example.searchmovie.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.searchmovie.R;
import com.example.searchmovie.adapters.TVShowsAdapter;
import com.example.searchmovie.databinding.ActivityMainBinding;
import com.example.searchmovie.models.TVshow;
import com.example.searchmovie.viewmodels.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MostPopularTVShowsViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private List<TVshow> tVshows = new ArrayList<>();
    private TVShowsAdapter tvShowsAdapter;

    private int currentPage = 1;
    private int totalAvailablePages = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();

    }

    private void doInitialization() {
        activityMainBinding.tvShowsRecyclerview.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        tvShowsAdapter = new TVShowsAdapter(tVshows);
        activityMainBinding.tvShowsRecyclerview.setAdapter(tvShowsAdapter);

        activityMainBinding.tvShowsRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!activityMainBinding.tvShowsRecyclerview.canScrollVertically(1)) {
                    if (currentPage <= totalAvailablePages) {
                        currentPage += 1;
                        getMostPopularTVShows();
                    }
                }
            }
        });

        // search
        activityMainBinding.imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SearchActivity.class));
            }
        });

        getMostPopularTVShows();

    }

    private void getMostPopularTVShows() {
        toggleLoading();
//        activityMainBinding.setIsLoading(true);
        viewModel.getMostPopularTVShows(currentPage).observe(this, mostPopularTVshowsResponse -> {
//            activityMainBinding.setIsLoading(false);
            toggleLoading();
            if (mostPopularTVshowsResponse != null) {
                totalAvailablePages = mostPopularTVshowsResponse.getTotalpages();
                if (mostPopularTVshowsResponse.gettVshows() != null) {
                    int oldcount = tVshows.size();
                    tVshows.addAll(mostPopularTVshowsResponse.gettVshows());
//                    tvShowsAdapter.notifyDataSetChanged();
                   tvShowsAdapter.notifyItemRangeInserted(oldcount,tVshows.size());
                }
            }
        });
    }

    public void toggleLoading() {
        if (currentPage == 1) {
            if (activityMainBinding.getIsLoading() != null && activityMainBinding.getIsLoading()) {
                activityMainBinding.setIsLoading(false);
            } else {
                activityMainBinding.setIsLoading(true);
            }
        } else {
            if (activityMainBinding.getIsLoadingMore() != null && activityMainBinding.getIsLoadingMore()) {
                activityMainBinding.setIsLoadingMore(false);
            } else {
                activityMainBinding.setIsLoadingMore(true);
            }
        }
    }
}