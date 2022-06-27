package com.example.searchmovie.response;

import com.example.searchmovie.models.TVshow;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShowResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("pages")
    private int totalpages;

    @SerializedName("tv_shows")
    private List<TVshow>tVshows;

    public int getPage() {
        return page;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public List<TVshow> gettVshows() {
        return tVshows;
    }
}
