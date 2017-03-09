package com.alex.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public final class MyController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void okAction(ActionEvent event) {
        System.out.println("Click ok button :" + username.getText());
    }

    public void cancelAction(ActionEvent event) {
        System.out.println("Click cancel button :" + password.getText());
    }
}
