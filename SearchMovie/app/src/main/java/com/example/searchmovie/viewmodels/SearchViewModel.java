package com.example.searchmovie.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.searchmovie.response.TVShowResponse;
import com.example.searchmovie.respositories.SearchTVShowRepository;

public class SearchViewModel extends ViewModel {
    private SearchTVShowRepository searchTVShowRepository;

    public SearchViewModel() {
        searchTVShowRepository  = new SearchTVShowRepository();
    }

    public LiveData<TVShowResponse>searchTVShow(String query, int page){
        return searchTVShowRepository.searchTVShow(query,page);
    }
}
