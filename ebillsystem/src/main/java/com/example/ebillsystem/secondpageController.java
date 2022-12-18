package com.example.ebillsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class secondpageController {

    @FXML
    private TextField meterfield;

    @FXML
    private TextField monthfield;

    @FXML
    private TextField namefield;

    @FXML
    private Button nextbutton;

    @FXML
    private Label nextmessagelabel;

    @FXML
    private Button powertariff;

    @FXML
    private Button prevbutton;

    @FXML
    private TextField unitfield;

    @FXML
    void nextbuttonOnAction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("lastpage.fxml"));
        Stage window = (Stage) nextbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }

    @FXML
    void powertariffOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("3rdpage.fxml"));
        Stage window = (Stage) powertariff.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }

    @FXML
    void prevbuttonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage window = (Stage) prevbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }

}
