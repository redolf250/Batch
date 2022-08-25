package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.utils.WindowsUtils.*;

@Component
public class Dashboard implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Pane bottom_panel;

    @FXML
    private JFXButton btn_batch;

    @FXML
    private JFXButton btn_database;

    @FXML
    private JFXButton btn_help;

    @FXML
    private JFXButton btn_report;

    @FXML
    private Label ibatch_desktop;

    @FXML
    private Pane left_panel;

    @FXML
    private StackPane stackpane;

    @FXML
    private Pane top_bar;

    @FXML
    private Pane top_bar_items;

    @FXML
    private VBox vbox_bottom;

    @FXML
    private VBox vbox_top;

    @FXML
    private Label version_info;

    @FXML
    private Label connection_status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadFxml(stackpane,FXML_NAME+"main_batch.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void  database(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"database.fxml");
    }

    @FXML
    private void  batch(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"main_batch.fxml");
    }

    @FXML
    private void  report(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"report.fxml");
    }

    @FXML
    private void  help(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"help.fxml");
    }

    @FXML
    private void closeApplication(MouseEvent event){
        close();
    }

    @FXML
    private void onWindowDragged(MouseEvent event){
        drag(event, anchorpane);
    }

    @FXML
    private void onMinimized(MouseEvent event){
       // minimize(minimize);
    }

    @FXML
    private void onMousePressed(MouseEvent event){
        press(event, anchorpane);
    }

}
