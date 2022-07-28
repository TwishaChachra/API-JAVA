package com.example.assignment2gc200474646;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class SceneChanger {
    public static void changeScenes(ActionEvent event, String fxmlFile, Integer cases) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        TrackerDetailsController controller = fxmlLoader.getController();
        controller.loadTrackerDetails(cases);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
