package com.application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import static com.application.animation.CustomAnimation.chartAnimation;
import static com.application.utils.WindowsUtils.FXML_NAME;
import static com.application.utils.WindowsUtils.loadFxml;

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

    private Set<String>possibleWords = new HashSet<>();
    private AutoCompletionBinding<String> autoCompletionBinding;

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
                new PieChart.Data("Multiple", 30)
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
                new PieChart.Data("CSV", 40),
                new PieChart.Data("XML", 20)
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


    @FXML
    private void pieChart(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"piechart.fxml");
    }

    @FXML
    private void tableview(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"tableview.fxml");
    }

    @FXML
    private void learn(){

        autoCompletionBinding = TextFields.bindAutoCompletion(search,possibleWords);
        search.setOnKeyPressed(((KeyEvent event) -> {
            switch (event.getCode()) {
                case ENTER -> {
                    learnWord(search.getText());
                    break;
                }

            }
        }));
    }

    private void learnWord(String text) {
        possibleWords.add(text);
        if (autoCompletionBinding!= null) {
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding = TextFields.bindAutoCompletion(search,possibleWords);
    }
}
