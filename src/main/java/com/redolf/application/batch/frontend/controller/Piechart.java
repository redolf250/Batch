package com.application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

import static com.application.animation.CustomAnimation.chartAnimation;

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

        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(
                new PieChart.Data("Successful", 29),
                new PieChart.Data("Rollback", 30),
                new PieChart.Data("Schedule", 30)
        );
        transactions.setData(pieChart);
        chartAnimation(transactions);

        ObservableList<PieChart.Data> resource = FXCollections.observableArrayList(
                new PieChart.Data("Single", 40),
                new PieChart.Data("Multiple", 30),
                new PieChart.Data("Single", 15),
                new PieChart.Data("Multiple", 20)
        );
        resourse_type.setData(resource);
        chartAnimation(resourse_type);

        ObservableList<PieChart.Data> operation = FXCollections.observableArrayList(
                new PieChart.Data("Read", 29),
                new PieChart.Data("Write", 15),
                new PieChart.Data("S Read", 10),
                new PieChart.Data("S Write", 40)
        );
        operation_type.setData(operation);
        chartAnimation(operation_type);


        ObservableList<PieChart.Data> databases = FXCollections.observableArrayList(
                new PieChart.Data("Oracle", 21),
                new PieChart.Data("MS SQL", 30),
                new PieChart.Data("MySQL", 10),
                new PieChart.Data("Derby", 40),
                new PieChart.Data("PostgreSQL", 10)
        );
        transactions1.setData(databases);
        chartAnimation(transactions1);

        ObservableList<PieChart.Data> resource1 = FXCollections.observableArrayList(
                new PieChart.Data("Single", 40),
                new PieChart.Data("Multiple", 30),
                new PieChart.Data("Single", 15),
                new PieChart.Data("Multiple", 20)
        );
        resourse_type1.setData(resource1);
        chartAnimation(resourse_type1);

        ObservableList<PieChart.Data> operation1 = FXCollections.observableArrayList(
                new PieChart.Data("Read", 29),
                new PieChart.Data("Write", 15),
                new PieChart.Data("S Read", 10),
                new PieChart.Data("S Write", 40)
        );
        operation_type1.setData(operation1);
        chartAnimation(operation_type1);
    }
}
