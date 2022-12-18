package com.example.ebillsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class HelloController {
    @FXML
    private Button loginbutton;
    @FXML
    private Button cancelbutton;
    @FXML
    private Label loginmessagelabel;
    @FXML
    private TextField usernametextfield;
    @FXML
    private PasswordField passwordpasswordfield;


    @FXML
    private TextField namefield;
    @FXML
    private TextField meterfield;
    @FXML
    private TextField unitfield;
    @FXML
    private TextField monthfield;
    @FXML
    private Button prevbutton;
    @FXML
    private Button powertariff;
    @FXML
    private Button nextbutton;
    @FXML
    private Label nextmessagelabel;
    @FXML
    private Button backbutton;

    @FXML
    private Button signup;

    public void Signup(ActionEvent e)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        Stage window=(Stage) signup.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));
    }


    public void backbuttonOnAction(ActionEvent e) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("secondpage.fxml"));
            Stage window = (Stage) backbutton.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));
        } catch (Exception c) {
            c.printStackTrace();

        }
    }

    public void prevbuttonOnAction(ActionEvent e) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage window = (Stage) prevbutton.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));
        } catch (Exception a) {
            a.printStackTrace();

        }


    }


    public void loginbuttonOnAction(ActionEvent e) {

        if (usernametextfield.getText().isBlank() == false && passwordpasswordfield.getText().isBlank() == false) {
            //LoginMessageLabel.setText("You try to login!!");
            validateLogin();
            //stage.initStyle(StageStyle.UNDECORATED);
        } else {
            loginmessagelabel.setText("Please Enter Username and Password");
        }
    }

    public void cancelbuttonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM userinfo WHERE username = '" + usernametextfield.getText() + "' AND password = '" + passwordpasswordfield.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    // loginmessagelabel.setText("Welcome!");
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("secondpage.fxml"));
                    Stage window = (Stage) loginbutton.getScene().getWindow();
                    window.setScene(new Scene(fxmlLoader.load(), 600, 400));
                } else {
                    loginmessagelabel.setText("Invalid Login.Please try again.");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}

