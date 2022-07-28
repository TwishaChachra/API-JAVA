package com.example.assignment2gc200474646;
import com.google.gson.annotations.SerializedName;

public class TrackerDetails {
    @SerializedName("Country_Name")
    private String country_name;

    @SerializedName("Total_Tests")
    private String total_tests;

    @SerializedName("Total_Recovered")
    private String total_recovered;

    @SerializedName("Active_Cases")
    private String active_cases;


    public String getCountry_Name() {
        return country_name;
    }

    public String getTotal_Tests() {
        return total_tests;
    }

    public String getTotal_Recovered() {
        return total_recovered;
    }

    public String getActive_Cases() {
        return active_cases;
    }


}
