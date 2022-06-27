package com.example.searchmovie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchmovie.R;
import com.example.searchmovie.databinding.ItemContainerTvShowBinding;
import com.example.searchmovie.listeners.TVShowsListener;
import com.example.searchmovie.models.TVshow;

import java.util.List;

public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.TVShowsviewHolder>  {
    private List<TVshow> tVshowList;
    private LayoutInflater layoutInflater;

    public TVShowsAdapter(List<TVshow> tVshowList) {
        this.tVshowList = tVshowList;
    }

    @NonNull
    @Override
    public TVShowsviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_container_tv_show,parent,false
        );
        return new TVShowsviewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowsviewHolder holder, int position) {
        holder.bindTVShow(tVshowList.get(position));
    }

    @Override
    public int getItemCount() {
        return tVshowList.size();
    }


    public static class TVShowsviewHolder extends RecyclerView.ViewHolder{
        private ItemContainerTvShowBinding  itemContainerTvShowBinding;


        public TVShowsviewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding) {
            super(itemContainerTvShowBinding.getRoot());
            this.itemContainerTvShowBinding = itemContainerTvShowBinding;
        }

        public void bindTVShow(TVshow tVshow){
            itemContainerTvShowBinding.setTvshow(tVshow);
            itemContainerTvShowBinding.executePendingBindings();
        }
    }
}
