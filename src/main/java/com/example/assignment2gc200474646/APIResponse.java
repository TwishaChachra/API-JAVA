package com.example.assignment2gc200474646;

import com.google.gson.annotations.SerializedName;

public class APIResponse {

    @SerializedName("Search")
    public COVID19Tracker[] search;

    public String totalResults;

    @SerializedName("Response")
    public String response;

    public COVID19Tracker[] getSearch() {
        return search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }
}
