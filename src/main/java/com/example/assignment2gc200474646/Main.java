package com.example.assignment2gc200474646;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
   public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Find COVID19 stats!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
        APIResponse apiResponse = APIUtility.getCOVID19TrackerFromJSONFile("apiResponse.json");
        System.out.println(apiResponse);
        APIResponse apiResponse2 = APIUtility.getCOVID19TrackerFromRapidApiQuick("UK");
        System.out.println(apiResponse2);
    }
}