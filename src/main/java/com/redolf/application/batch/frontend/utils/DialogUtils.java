package com.redolf.application.batch.frontend.utils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DialogUtils {

    public static String HEADING = "Alert";
    public static String SEARCH_CONTENT = "Search field cannot be empty";

    public static String EMPTY_FIELD = "Datasource properties must be specified";

    public static String CONFIRM = "Confirm";

    public static String DATASOURCE = "Datasource instance successfully created";

    public static String DATASOURCE_EXIST = "Datasource with such properties\nalready exists";

    public static String INVALID_OPERATION = "Datasource properties must be specified\nto perform this operation";

    public static String DATASOURCE_NOT_FOUND = "Datasource with such ID is not found";

    public static String DATASOURCE_UPDATE = "Datasource properties successfully updated";

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
