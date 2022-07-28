package com.example.assignment2gc200474646;
import com.google.gson.annotations.SerializedName;

public class COVID19Tracker {
    @SerializedName("CountryName")
    public String countryName;

    @SerializedName("Cases")
    public Integer cases;

    public Integer deaths;

    @SerializedName("StateName")
    public String stateName;

    @SerializedName("Population")
    public String population;

    public String getCountryName() {
        return countryName;
    }

    public Integer getCases() {
        return cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public String getStateName() {
        return stateName;
    }

    public String getPopulation() {
        return population;
    }

}
