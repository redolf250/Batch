package com.redolf.application.batch.frontend.piechart;

import com.redolf.application.batch.frontend.operations.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import static com.redolf.application.batch.frontend.queries.Queries.*;
import static com.redolf.application.batch.frontend.animation.CustomAnimation.chartAnimation;

public class Statistics {
    public static void getOperation(PieChart pieChart){
        ObservableList<PieChart.Data> batchStatus = FXCollections.observableArrayList(
                new PieChart.Data("Successful", Helper.count(COUNT_SUCCESSFUL_OPERATION)),
                new PieChart.Data("Rollback", Helper.count(COUNT_ROLLBACK_OPERATION))
        );
        pieChart.setData(batchStatus);
        chartAnimation(pieChart);
    }

    public static void getResourceType(PieChart pieChart){
        ObservableList<PieChart.Data> typeOfResource = FXCollections.observableArrayList(
                new PieChart.Data("Single", Helper.count(COUNT_SINGLE_RESOURCES_OPERATION)),
                new PieChart.Data("Multiple", Helper.count(COUNT_MULTIPLE_RESOURCES_OPERATION))
        );
        pieChart.setData(typeOfResource);
        chartAnimation(pieChart);
    }

    public static void getBatchType(PieChart pieChart){
        ObservableList<PieChart.Data> operationTypeList = FXCollections.observableArrayList(
                new PieChart.Data("Read", Helper.count(COUNT_READ_OPERATION)),
                new PieChart.Data("Write", Helper.count(COUNT_WRITE_OPERATION)),
                new PieChart.Data("S Read", Helper.count(COUNT_SCHEDULE_READ_OPERATION)),
                new PieChart.Data("S Write", Helper.count(COUNT_SCHEDULE_WRITE_OPERATION))
        );
        pieChart.setData(operationTypeList);
        chartAnimation(pieChart);
    }

    public static void getDatabases(PieChart pieChart){
        ObservableList<PieChart.Data> listOfDatabases = FXCollections.observableArrayList(
                new PieChart.Data("Oracle", 21),
                new PieChart.Data("MS SQL", 30),
                new PieChart.Data("MySQL", 10),
                new PieChart.Data("PostgresSQL", 10)
        );
        pieChart.setData(listOfDatabases);
        chartAnimation(pieChart);
    }

    public static void getFilesType(PieChart pieChart){
        ObservableList<PieChart.Data> fileTypeCollection = FXCollections.observableArrayList(
                new PieChart.Data("CSV", Helper.count(COUNT_ALL_CSV)),
                new PieChart.Data("XML", Helper.count(COUNT_ALL_XML))
        );
        pieChart.setData(fileTypeCollection);
        chartAnimation(pieChart);
    }

    public static void getTotalForSchemaAndTable(PieChart pieChart){
        ObservableList<PieChart.Data> totalForEachType = FXCollections.observableArrayList(
                new PieChart.Data("Schemas", Helper.count(COUNT_ALL_SCHEMAS)),
                new PieChart.Data("Tables", Helper.count(COUNT_ALL_TABLE))
        );
        pieChart.setData(totalForEachType);
        chartAnimation(pieChart);
    }
}
