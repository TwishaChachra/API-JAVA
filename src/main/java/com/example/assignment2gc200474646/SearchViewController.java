package com.example.assignment2gc200474646;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

    public class SearchViewController implements Initializable{

        @FXML
        private ListView<COVID19Tracker> resultListView;

        @FXML
        private TextField searchTextField;
        @FXML
        private Label info;
        @FXML
        void searchCOVID19Tracker(ActionEvent event) {
            APIResponse apiResponse = APIUtility.getCOVID19TrackerFromRapidApiQuick(searchTextField.getText());
            resultListView.getItems().clear();
            if (apiResponse.getSearch() != null)
            {
                resultListView.getItems().addAll(apiResponse.getSearch());
                info.setText("");
            }
            else
                info.setText("Data is not available!");
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
        @FXML
        private void getDetails(ActionEvent event) throws IOException {
            Integer cases = resultListView.getSelectionModel().getSelectedItem().getCases();
            System.out.println("Cases : "+cases);
            SceneChanger.changeScenes(event, "tracker-details.fxml",cases);
        }
    }


