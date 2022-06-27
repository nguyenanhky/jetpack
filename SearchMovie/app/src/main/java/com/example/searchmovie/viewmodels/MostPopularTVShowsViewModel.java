package com.example.searchmovie.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchmovie.response.TVShowResponse;
import com.example.searchmovie.respositories.MostPopularTVShowsRespository;

public class MostPopularTVShowsViewModel extends ViewModel {
    private MostPopularTVShowsRespository mostPopularTVShowsRespository;

    public MostPopularTVShowsViewModel() {
        mostPopularTVShowsRespository = new MostPopularTVShowsRespository();
    }

    public LiveData<TVShowResponse>getMostPopularTVShows(int page){
        return  mostPopularTVShowsRespository.getMostPopularTVShows(page);
    }


}
