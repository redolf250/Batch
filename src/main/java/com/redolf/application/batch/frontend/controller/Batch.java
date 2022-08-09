package com.application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.application.utils.WindowsUtils.FXML_NAME;
import static com.application.utils.WindowsUtils.loadFxml;

public class Batch implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane main_anchorpane;

    @FXML
    private StackPane stackpane;

    @FXML
    private JFXButton multi_resource;

    @FXML
    private JFXButton single_resource;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void  single_resource(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"single_batch.fxml");
    }

    @FXML
    private void  multi_resource(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"multi_batch.fxml");
    }
}
