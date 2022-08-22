package com.redolf.application.batch.frontend.utils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DialogUtils {

    public static String READ_JOB_DONE = "Batch read job done, files are save at\n ";

    public static String FILE_TO_SAVE = "File to save to must be specified!";
    public static String UNSUPPORTED_FILE_FORMAT= "The software currently supports only csv and\n xml file formats.";
    public static String VALUES_TRANSMITTED = "All batch job parameters captured,\nyou can start a batch job!";

    public static String ALL_VARIABLES = "All parameters must be specified and\nshould be valid!";

    public static String BATCH_TYPE_SELECT = "Batch type must be selected!";
    public static String CHOOSE_FILE="Resource must be selected to run\nbatch job! ";
    public static String HEADING = "Alert";
    public static String SEARCH_CONTENT = "Search field cannot be empty";

    public static String EMPTY_FIELD = "Datasource properties must be specified";

    public static String CONFIRM = "Confirm";

    public static String DATASOURCE = "Datasource instance successfully created";

    public static String DATASOURCE_EXIST = "Datasource with such properties\nalready exists";

    public static String INVALID_OPERATION = "Datasource properties must be specified\nto perform this operation";

    public static String DATASOURCE_NOT_FOUND = "Datasource with such ID is not found";

    public static String DATASOURCE_UPDATE = "Datasource properties successfully updated";

    public static String BAD_FILE_FORMAT = "Resource file format is invalid!";

    public static String SOME_FIELD_CANNOT_BE_EMPTY = "Some fields cannot be empty!";

    public static String BATCH_COMPLETED = "Batch job completed successfully!";

    public static void showDialog(StackPane stackPane, AnchorPane anchorPane, String content, String heading) {
        BoxBlur boxBlur=new BoxBlur(10,10,2);
        JFXDialogLayout layout=new JFXDialogLayout();
        final JFXDialog dialog=new JFXDialog(stackPane,layout, JFXDialog.DialogTransition.TOP);
        layout.setBody(new Text(content));
        layout.setHeading(new Text(heading));
        layout.setPickOnBounds(true);
        JFXButton button1=new JFXButton("Okay");
        button1.setStyle("-fx-background-color:#0071ca;-fx-background-radius:15px;-fx-text-fill:#ffffff;-fx-font-family:Bodoni MT Condensed;-fx-font-size:14;");
        button1.setPrefWidth(80);
        button1.setPrefHeight(20);
        button1.setOnAction(event -> dialog.close());
        layout.setActions(button1);
        dialog.show();
        anchorPane.setEffect(boxBlur);
        dialog.setOnDialogClosed(event -> anchorPane.setEffect(null));
    }


}
