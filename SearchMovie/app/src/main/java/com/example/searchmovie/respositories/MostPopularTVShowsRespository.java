package com.example.searchmovie.respositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.searchmovie.netword.ApiClient;
import com.example.searchmovie.netword.ApiService;
import com.example.searchmovie.response.TVShowResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostPopularTVShowsRespository {
    private ApiService apiService;

    public MostPopularTVShowsRespository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }
    public LiveData<TVShowResponse> getMostPopularTVShows(int page) {
        MutableLiveData<TVShowResponse> data = new MutableLiveData<>();
        apiService.getMostPopularTVshow(page).enqueue(new Callback<TVShowResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVShowResponse> call, @NonNull Response<TVShowResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowResponse> call,@NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
