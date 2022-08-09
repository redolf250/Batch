package com.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.application.utils.Window.loadWindow;

public class Help implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void account(MouseEvent event) throws IOException {
       loadWindow("account.fxml");
    }

    @FXML
    private void feedback(MouseEvent event) throws IOException {
        loadWindow("feedback.fxml");
    }

    @FXML
    private void about(MouseEvent event) throws IOException {
        loadWindow("about.fxml");
    }
}
