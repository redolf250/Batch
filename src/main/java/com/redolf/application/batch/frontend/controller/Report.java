package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.textfield.CustomTextField;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.piechart.Statistics.*;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.FXML_NAME;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.loadFxml;

@Component
public class Report implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane main_anchorpane;

    @FXML
    private PieChart operation_type;

    @FXML
    private PieChart operation_type1;

    @FXML
    private JFXButton piechartView;

    @FXML
    private PieChart resourse_type;

    @FXML
    private PieChart resourse_type1;

    @FXML
    private CustomTextField search;

    @FXML
    private StackPane stackpane;

    @FXML
    private JFXButton tableview;

    @FXML
    private PieChart transactions;

    @FXML
    private PieChart transactions1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            getOperation(transactions);
            getDatabases(transactions1);
            getResourceType(resourse_type);
            getTotalForSchemaAndTable(resourse_type1);
            getBatchType(operation_type);
            getFilesType(operation_type1);
    }

    @FXML
    private void pieChart(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"piechart.fxml");
    }

    @FXML
    private void tableview(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"tableview.fxml");
    }
}
