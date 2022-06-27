package com.example.searchmovie.models;

import com.google.gson.annotations.SerializedName;

public class TVshow {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("permalink")
    private String permalink;

    @SerializedName("start_date")
    private String start_date;

    @SerializedName("end_date")
    private String end_date;

    @SerializedName("country")
    private String country;

    @SerializedName("network")
    private String network;

    @SerializedName("status")
    private String status;

    @SerializedName("image_thumbnail_path")
    private String thumbnail;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getCountry() {
        return country;
    }

    public String getNetword() {
        return network;
    }

    public String getStatus() {
        return status;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
