package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.textfield.CustomTextField;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.utils.WindowsUtils.FXML_NAME;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.loadFxml;

@Component
public class Batch implements Initializable {


    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ComboBox<?> authentication_type;

    @FXML
    private BorderPane borderpane;

    @FXML
    private JFXButton btn_read;

    @FXML
    private JFXButton btn_reset;

    @FXML
    private JFXButton btn_search;

    @FXML
    private JFXButton btn_test_connection;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXButton btn_write;

    @FXML
    private CustomTextField chosefile;

    @FXML
    private CustomTextField corepoolsize;

    @FXML
    private JFXRadioButton csv_type;

    @FXML
    private PasswordField database_field;

    @FXML
    private ToggleGroup file;

    @FXML
    private CustomTextField gridesize;

    @FXML
    private CustomTextField host_field;

    @FXML
    private ComboBox<?> hours;

    @FXML
    private CustomTextField keepalivetime;

    @FXML
    private AnchorPane main_anchorpane;

    @FXML
    private CustomTextField maxcimum;

    @FXML
    private CustomTextField maxpoolsize;

    @FXML
    private CustomTextField minimum;

    @FXML
    private ComboBox<?> minute;

    @FXML
    private ComboBox<?> month;

    @FXML
    private ComboBox<?> month_day;

    @FXML
    private CustomTextField name_field;

    @FXML
    private ToggleGroup operation;

    @FXML
    private AnchorPane pane;

    @FXML
    private PasswordField password_field;

    @FXML
    private CustomTextField port_field;

    @FXML
    private CustomTextField queueCapacity;

    @FXML
    private JFXRadioButton read;

    @FXML
    private CustomTextField retry_limit;

    @FXML
    private CustomTextField rows_to_skip;

    @FXML
    private CustomTextField savefilname;

    @FXML
    private JFXButton schedule;

    @FXML
    private JFXRadioButton schedule_read;

    @FXML
    private JFXRadioButton schedule_write;

    @FXML
    private CustomTextField search_field;

    @FXML
    private CustomTextField skip_policy;

    @FXML
    private StackPane stackpane;

    @FXML
    private CustomTextField tablename;

    @FXML
    private CustomTextField thread;

    @FXML
    private PasswordField url_field;

    @FXML
    private CustomTextField user_field;

    @FXML
    private ComboBox<?> week_day;

    @FXML
    private JFXRadioButton write;

    @FXML
    private JFXRadioButton xml_type;

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
