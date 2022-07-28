package com.example.assignment2gc200474646;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
public class APIUtility {

    public static APIResponse getCOVID19TrackerFromJSONFile(String fileName)
    {
        Gson gson = new Gson();
        APIResponse response = null;

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ){
            response = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }


    public static APIResponse getCOVID19TrackerFromRapidApi(String searchTerm)
    {
        searchTerm = searchTerm.replace(" ", "%20");

        String uri = "https://corona-virus-world-and-india-data.p.rapidapi.com/api"+searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        try {
            HttpResponse<Path> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return getCOVID19TrackerFromJSONFile("javaApiFetched.json");
    }
    public static APIResponse getCOVID19TrackerFromRapidApiQuick(String searchTerm){

        searchTerm = searchTerm.replace(" ", "%20");

        String uri = "https://corona-virus-world-and-india-data.p.rapidapi.com/api"+searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), APIResponse.class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    public static TrackerDetails getTrackerDetails(Integer cases)
    {
        String uri = "https://corona-virus-world-and-india-data.p.rapidapi.com/api"+cases;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), TrackerDetails.class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
