package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.piechart.Statistics.*;
import static com.redolf.application.batch.frontend.piechart.Statistics.getTotalForSchemaAndTable;


@Component
public class Piechart implements Initializable {

    @FXML
    private JFXButton btn_write;

    @FXML
    private JFXButton btn_write1;

    @FXML
    private PieChart operation_type;

    @FXML
    private PieChart operation_type1;

    @FXML
    private PieChart resourse_type;

    @FXML
    private PieChart resourse_type1;

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
}
