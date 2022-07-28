package com.example.assignment2gc200474646;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

    public class TrackerDetailsController {


        @FXML
        private Label activeCasesLabel;

        @FXML
        private Label countryNameLabel;

        @FXML
        private Label totalRecoveredLabel;
        private TrackerDetails covid19Tracker;

        @FXML
        private Label totalTestsLabel;
        public void loadTrackerDetails(Integer cases)
        {
     covid19Tracker = APIUtility.getTrackerDetails(cases);

            activeCasesLabel.setText(covid19Tracker.getActive_Cases());
            countryNameLabel.setText(covid19Tracker.getCountry_Name());
            totalRecoveredLabel.setText(covid19Tracker.getTotal_Recovered());
            totalTestsLabel.setText(covid19Tracker.getTotal_Tests());

        }
    }

