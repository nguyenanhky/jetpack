package com.example.searchmovie.netword;

import com.example.searchmovie.response.TVShowResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("most-popular")
    Call<TVShowResponse> getMostPopularTVshow(@Query("page") int page);

    @GET("search")
    Call<TVShowResponse>searchTVShow(@Query("q") String query,@Query("page") int page);
}
