package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.redolf.application.batch.backend.models.*;
import com.redolf.application.batch.frontend.enums.Operation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import org.controlsfx.control.textfield.CustomTextField;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.redolf.application.batch.backend.service.DatasourceService.*;
import static com.redolf.application.batch.frontend.utils.DialogUtils.*;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.FXML_NAME;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.loadFxml;

@Component
public class Batch extends Database implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ComboBox<String> driver_class;

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
    private CustomTextField database_field;

    @FXML
    private ToggleGroup file;

    @FXML
    private CustomTextField gridesize;

    @FXML
    private CustomTextField host_field;

    @FXML
    private ComboBox<Integer> hours;

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
    private ComboBox<Integer> minute;

    @FXML
    private ComboBox<Integer> month;

    @FXML
    private ComboBox<Integer> month_day;

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
    private CustomTextField url_field;

    @FXML
    private CustomTextField user_field;

    @FXML
    private ComboBox<Integer> week_day;

    @FXML
    private JFXRadioButton write;

    @FXML
    private JFXRadioButton xml_type;

    @FXML
    private Label scene_number;

    private File selectedFile = null;
    private Parameters parameters = null;
    private Summary summary = null;

    private Status status = null;

    private Types types = null;

    private BatchCategory category = null;

    private final String CSV_FILE = "csv";
    private final String XML_FILE = "xml";

    ObservableList<Integer> minutes = FXCollections.observableArrayList(getMinutes());

    ObservableList<Integer> months = FXCollections.observableArrayList(getMonths());

    ObservableList<Integer> hour = FXCollections.observableArrayList(getHours());

    ObservableList<Integer> week_days = FXCollections.observableArrayList(getWeekDays());

    ObservableList<Integer> month_days = FXCollections.observableArrayList(getMonthDays());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      minute.setItems(minutes);
      month.setItems(months);
      hours.setItems(hour);
      week_day.setItems(week_days);
      month_day.setItems(month_days);
    }

    private List<Integer> getMinutes() {
        List<Integer> minutes = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            minutes.add(i);
        }
        return minutes;
    }

    private List<Integer> getMonths() {
        List<Integer> months = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            months.add(i);
        }
        return months;
    }

    private List<Integer> getHours() {
        List<Integer> hours = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            hours.add(i);
        }
        return hours;
    }

    private List<Integer> getWeekDays() {
        List<Integer> week_day = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            week_day.add(i);
        }
        return week_day;
    }

    private List<Integer> getMonthDays() {
        List<Integer> month_day = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            month_day.add(i);
        }
        return month_day;
    }

    @FXML
    private void  single_resource(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"single_batch.fxml");
    }

    @FXML
    private void  multi_resource(ActionEvent event) throws IOException {
        loadFxml(stackpane,FXML_NAME+"multi_batch.fxml");
    }

    @FXML
    private void showOpenDialog(MouseEvent event){
        selectedFile();
    }

    private void selectedFile(){
        chosefile.setOnMouseClicked(event -> {
            FileChooser chooser = new FileChooser();
            selectedFile = chooser.showOpenDialog(null);
            if (selectedFile==null){
                showDialog(stackpane,pane,CHOOSE_FILE,HEADING);
            }else if(selectedFile.getName().endsWith(CSV_FILE) == true || selectedFile.getName().endsWith(XML_FILE) == true){
                chosefile.setText(selectedFile.getName());
                System.out.println(selectedFile.getAbsolutePath());
                System.out.println(selectedFile.getName());
                System.out.println(selectedFile.getPath());
                System.out.println(selectedFile.getName().endsWith("mp4"));
            }else {
                showDialog(stackpane,pane,BAD_FILE_FORMAT,HEADING);
            }
        });
    }


    @FXML
    private void writeBatchJob(){

        int number = Integer.parseInt(scene_number.getText());
        if(name_field.getText().isEmpty() && chosefile.getText().isEmpty()){
            showDialog(stackpane,pane,SOME_FIELD_CANNOT_BE_EMPTY,HEADING);
        }else {
            if (number==1){
                startSingleResourceJob();
            }else if (number==2){

            }
        }
    }

    private void startSingleResourceJob() {
        parameters = new Parameters();
        parameters.setSummary(summary);
        parameters.setStatus(status);
        parameters.setType(types);
        parameters.setCategory(category);

        parameters.setMinimum_lines(Long.valueOf(minimum.getText().trim()));
        parameters.setMaximum_lines(Long.valueOf(maxcimum.getText().trim()));
        parameters.setGride_size(Long.valueOf(gridesize.getText().trim()));
        parameters.setNumber_of_threads(Integer.parseInt(thread.getText().trim()));
        parameters.setRows_to_skip(Integer.parseInt(rows_to_skip.getText().trim()));
        parameters.setSkip_policy(Integer.parseInt(skip_policy.getText().trim()));
        parameters.setCore_pool_size(Long.valueOf(corepoolsize.getText().trim()));
        parameters.setMax_pool_size(Long.valueOf(maxpoolsize.getText().trim()));
        parameters.setQueue_capacity(Long.valueOf(queueCapacity.getText().trim()));
        parameters.setRetry_limit(Integer.parseInt(retry_limit.getText().trim()));
        parameters.setKeep_alive_time(Long.valueOf(keepalivetime.getText().trim()));
        parameters.setDate(LocalDate.now());

        summary = new Summary();
        summary.setParameters(parameters);
        summary.setSchema_name(database_field.getText().trim());
        summary.setTable_name(tablename.getText().trim());
        summary.setTime(LocalTime.now());
        summary.setDate(LocalDate.now());
        if (csv_type.isSelected()){
            summary.setFile_type("CSV");
        }else if(xml_type.isSelected()){
            summary.setFile_type("XML");
        }else{
            summary.setFile_type("CSV");
        }

        status = new Status();
        status.setParameters(parameters);
        status.setStatus("SUCCESSFUL");

        types = new Types();
        types.setParameters(parameters);
        if (write.isSelected()){
            types.setOperation(Operation.WRITE);
        }else if(read.isSelected()) {
            types.setOperation(Operation.READ);
        }else {
            types.setOperation(Operation.WRITE);
        }

        category = new BatchCategory();
        category.setCategory_name("SINGLE");
        category.setParameters(parameters);
        validate();
        saveWriteBatchJobParameters(parameters);
        saveWriteBatchJobSummary(summary);
        saveWriteBatchStatus(status);
        saveWriteBatchTypes(types);
        saveWriteBatchCategory(category);
        showDialog(stackpane,pane,BATCH_COMPLETED,CONFIRM);
    }

    private void validate(){
        List<CustomTextField> fields =  fieldsList();
        for (CustomTextField field: fields) {
            if (field.getText().isEmpty()){
                showDialog(stackpane,pane,"",HEADING);
                break;
            }else{
                continue;
            }
        }
    }

    private List<CustomTextField> fieldsList(){
        List<CustomTextField> fields = new ArrayList<>();
        fields.add(minimum);
        fields.add(maxcimum);
        fields.add(gridesize);
        fields.add(corepoolsize);
        fields.add(thread);
        fields.add(queueCapacity);
        fields.add(skip_policy);
        fields.add(maxpoolsize);
        fields.add(keepalivetime);
        fields.add(rows_to_skip);
        fields.add(retry_limit);
        fields.add(tablename);
        fields.add(name_field);
        return fields;
    }

    @FXML
    private void resetFields(ActionEvent event){
      clearFields();
      clearBatchFields();
      driver_class.setPromptText("Driver name");
    }

    private void clearBatchFields(){
        List<CustomTextField> fields = fieldsList();
        for (CustomTextField field: fields) {
            field.clear();
        }
    }
}
