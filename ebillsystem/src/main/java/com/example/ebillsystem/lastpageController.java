package com.example.ebillsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class lastpageController {

    @FXML
    private Button exit;

    @FXML
    void exitOnAction(ActionEvent event) {

            Stage stage= (Stage) exit.getScene().getWindow();
            stage.close();
        }

    }



