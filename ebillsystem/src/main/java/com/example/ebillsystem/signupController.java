package com.example.ebillsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupController {

    @FXML
    private Button log;

    @FXML
    private Button ok;

    @FXML
    private PasswordField requestpassword;

    @FXML
    private TextField requestusername;

    Connection con;
    PreparedStatement pst;

    @FXML
    void Ok(ActionEvent event) {

        String username = requestusername.getText();
        String password = requestpassword.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ebill","root","Sahana23!!");

            pst = con.prepareStatement("insert into userinfo(username,password)values(?,?)");
            pst.setString(1,username);
            pst.setString(2,password);
            int status=pst.executeUpdate();

            if (status==1){
                System.out.println("record added");
                requestusername.setText("");
                requestpassword.setText("");
                requestusername.requestFocus();
               // messageaftersubmit.setText("request submitted");
            }else {
                System.out.println("record failed");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void login(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage window=(Stage) log.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

}
