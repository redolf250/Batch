package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import com.redolf.application.batch.frontend.models.Datasource_;
import com.redolf.application.batch.frontend.service.DatasourceService;
import com.redolf.application.batch.frontend.DTO.DatabaseData;
import com.redolf.application.batch.frontend.operations.DatabaseTable;
import com.redolf.application.batch.frontend.operations.Helper;
import com.redolf.application.batch.frontend.utils.DialogUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.textfield.CustomTextField;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.service.DatasourceService.findByName;
import static com.redolf.application.batch.frontend.service.DatasourceService.queryById;
import static com.redolf.application.batch.frontend.utils.DialogUtils.*;

public class Database implements Initializable {
    Datasource_ datasource = new Datasource_();
    private final DatasourceService service = new DatasourceService();

    @FXML
    private StackPane stackpane;

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
    private TableView<DatabaseData> data_items;

    @FXML
    private CustomTextField database_field;

    @FXML
    private ComboBox<String> driver_class;

    @FXML
    private CustomTextField host_field;

    @FXML
    private TableColumn<DatabaseData,String> hostname;

    @FXML
    private TableColumn<DatabaseData,String> id;

    @FXML
    private TableColumn<DatabaseData,String> name;

    @FXML
    private CustomTextField name_field;

    @FXML
    private AnchorPane pane;

    @FXML
    private PasswordField password_field;

    @FXML
    private TableColumn<DatabaseData,String> port;

    @FXML
    private CustomTextField port_field;

    @FXML
    private CustomTextField search_field;

    @FXML
    private CustomTextField url_field;

    @FXML
    private CustomTextField user_field;

    ObservableList<String> db_drivers;

    {
        try {
            db_drivers = FXCollections.observableArrayList(Helper.getDriverClass());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ObservableList<DatabaseData> items;

    {
        try {
            items = FXCollections.observableArrayList(DatabaseTable.getData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        driver_class.setItems(db_drivers);
        getData();
    }
    private void getData(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("database_name"));
        hostname.setCellValueFactory(new PropertyValueFactory<>("hostname"));
        port.setCellValueFactory(new PropertyValueFactory<>("port"));
        data_items.setItems(items);
    }

    @FXML
    private void insert(){
        if (name_field.getText().isEmpty()){
            showDialog(stackpane,pane,EMPTY_FIELD,HEADING);
        }else{
            List results = findByName(name_field.getText().trim());
            if (results.size()==0){
                validate();
                datasource.setDatabase_name(name_field.getText());
                datasource.setHostname(host_field.getText());
                datasource.setUsername(user_field.getText());
                datasource.setPort(Integer.parseInt(port_field.getText()));
                datasource.setCreated_at(LocalDate.now());
                datasource.setSchema_name(database_field.getText());
                datasource.setDriver_name(driver_class.getSelectionModel().getSelectedItem());
                datasource.setPassword(password_field.getText());
                datasource.setUrl(url_field.getText());
                DatasourceService.save(datasource);
                showDialog(stackpane,pane,DATASOURCE,CONFIRM);
            }else{
                showDialog(stackpane,pane,DATASOURCE_EXIST,HEADING);
            }
        }
    }

    private void validate(){
        List<CustomTextField> fields =  fieldsList();
        for (CustomTextField field: fields) {
            if (field.getText().isEmpty()){
            }else{

            }
        }
    }

    @FXML
    void clearFields(){
        List<CustomTextField> fields =  fieldsList();
        for (CustomTextField field: fields) {
            field.clear();
        }
        password_field.clear();
        name_field.clear();
        search_field.clear();
        url_field.clear();
    }

    private List<CustomTextField> fieldsList() {
        List<CustomTextField> fields = new ArrayList<>();
        fields.add(user_field);
        fields.add(host_field);
        fields.add(port_field);
        fields.add(database_field);
        fields.add(name_field);
        return fields;
    }
    @FXML
    private void delete(ActionEvent event){
        if (name_field.getText().isEmpty()){
            showDialog(stackpane,pane,INVALID_OPERATION,HEADING);
        }else {
            DatasourceService.delete(Integer.parseInt(search_field.getText()));
            showDialog(stackpane,pane,"Datasource successfully removed!",CONFIRM);
        }
    }

    @FXML
    void search(ActionEvent event){
        queryForDatasource();
    }

    public void queryForDatasource() {
        if (search_field.getText().isEmpty()){
            DialogUtils.showDialog(stackpane,pane,SEARCH_CONTENT,HEADING);
        }else {
            List result = queryById(Integer.parseInt(search_field.getText()));
            if (result.size() == 0){
                showDialog(stackpane,pane,DATASOURCE_NOT_FOUND,HEADING);
            }else {
                sendDataView();
            }
        }
    }

    private Datasource_ sendDataView() {
        Datasource_ datasource = DatasourceService.findById(Integer.parseInt(search_field.getText()));
            String port = String.valueOf(datasource.getPort());
            name_field.setText(datasource.getDatabase_name());
            host_field.setText(datasource.getHostname());
            user_field.setText(datasource.getUsername());
            port_field.setText(port);
            datasource.getCreated_at();
            database_field.setText(datasource.getSchema_name());
            driver_class.setValue(datasource.getDriver_name());
            password_field.setText(datasource.getPassword());
            url_field.setText(datasource.getUrl());
        return datasource;

    }

    @FXML
    private void update(ActionEvent event){
        if (name_field.getText().isEmpty()){
            showDialog(stackpane,pane,INVALID_OPERATION,HEADING);
        }else {
            validate();
            datasource.setDatabase_name(name_field.getText());
            datasource.setHostname(host_field.getText());
            datasource.setUsername(user_field.getText());
            datasource.setPort(Integer.parseInt(port_field.getText()));
            datasource.setCreated_at(LocalDate.now());
            datasource.setSchema_name(database_field.getText());
            datasource.setDriver_name(driver_class.getSelectionModel().getSelectedItem());
            datasource.setPassword(password_field.getText());
            datasource.setUrl(url_field.getText());
            DatasourceService.update(datasource, Integer.parseInt(search_field.getText()));
            showDialog(stackpane,pane,DATASOURCE_UPDATE,CONFIRM);
        }
    }

}
