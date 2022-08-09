package com.application.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.CustomTextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.application.table.ItemsLoader.loadTableItems;

public class Database implements Initializable {

    @FXML
    private ComboBox<?> authentication_type;

    @FXML
    private Label batch_id;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXButton btn_insert;

    @FXML
    private JFXButton btn_reset;

    @FXML
    private JFXButton btn_search;

    @FXML
    private JFXButton btn_test_connection;

    @FXML
    private JFXButton btn_update;

    @FXML
    private Label database;

    @FXML
    private PasswordField database_field;

    @FXML
    private ScrollPane database_items;

    @FXML
    private Label date;

    @FXML
    private Label file_type;

    @FXML
    private CustomTextField host_field;

    @FXML
    private VBox list_items;

    @FXML
    private CustomTextField name_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private CustomTextField port_field;

    @FXML
    private CustomTextField search_field;

    @FXML
    private HBox table_header;

    @FXML
    private PasswordField url_field;

    @FXML
    private CustomTextField user_field;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTableItems(list_items, "db_items.fxml");

    }
}
