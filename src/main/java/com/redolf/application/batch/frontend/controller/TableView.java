package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import com.redolf.application.batch.frontend.DTO.BatchParameters;
import com.redolf.application.batch.frontend.DTO.ScheduleParameters;
import com.redolf.application.batch.frontend.DTO.SearchBatch;
import com.redolf.application.batch.frontend.DTO.SummaryParameters;
import com.redolf.application.batch.frontend.connection.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.queries.Queries.*;

public class TableView implements Initializable {

    @FXML
    private javafx.scene.control.TableView<BatchParameters> batch_parameters;

    @FXML
    private TableColumn<BatchParameters, Long> id;

    @FXML
    private TableColumn<BatchParameters, Long> keep_alive;

    @FXML
    private TableColumn<BatchParameters, Long> gride_size;

    @FXML
    private TableColumn<BatchParameters, Long> max_pool_size;

    @FXML
    private TableColumn<BatchParameters, Long> max_value;

    @FXML
    private TableColumn<BatchParameters, Long> min_value;

    @FXML
    private TableColumn<BatchParameters, Integer> skip_rows;

    @FXML
    private TableColumn<BatchParameters, Integer> thread_number;

    @FXML
    private TableColumn<BatchParameters,Long> core_pool_size;

    @FXML
    private TableColumn<BatchParameters, Integer> queue_capacity;

    @FXML
    private TableColumn<BatchParameters, Integer> retry_limit;


    @FXML
    private TableColumn<BatchParameters, Integer> skip_policy;

    @FXML
    private JFXButton btn_export;

    @FXML
    private JFXButton btn_send;

    @FXML
    private DatePicker start_date;

    @FXML
    private DatePicker end_date;

    @FXML
    private javafx.scene.control.TableView<ScheduleParameters> schedule_parameters;

    @FXML
    private TableColumn<ScheduleParameters, Integer> month;

    @FXML
    private TableColumn<ScheduleParameters, Integer> schedule_id;
    @FXML
    private TableColumn<ScheduleParameters, String> week_day;

    @FXML
    private TableColumn<ScheduleParameters, Integer> day_month;

    @FXML
    private TableColumn<ScheduleParameters, Integer> hour;

    @FXML
    private TableColumn<ScheduleParameters, Integer> minute;

    @FXML
    private javafx.scene.control.TableView<SummaryParameters> batch_details;

    @FXML
    private TableColumn<ScheduleParameters, String> schema;

    @FXML
    private TableColumn<ScheduleParameters, String> file_type;

    @FXML
    private TableColumn<ScheduleParameters, Integer> summary_id;

    @FXML
    private TableColumn<ScheduleParameters, String> table;

    @FXML
    private TableColumn<ScheduleParameters, LocalTime> time;

    @FXML
    private TableColumn<ScheduleParameters, LocalDate> date;

    ObservableList<BatchParameters> listItems = FXCollections.observableArrayList();

    ObservableList<BatchParameters> new_listItems = FXCollections.observableArrayList();
    ObservableList<SummaryParameters> summaryObservableList = FXCollections.observableArrayList();
    ObservableList<ScheduleParameters> scheduleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
             setBatchParameters();
             setSummaryBatchParameters();
             setScheduleParam();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setSummaryBatchParameters() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_SUMMARY);
        while (resultSet.next()) {
            summaryObservableList.add(new SummaryParameters(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
                    resultSet.getString(6)));
        }
        summary_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        file_type.setCellValueFactory(new PropertyValueFactory<>("date"));
        schema.setCellValueFactory(new PropertyValueFactory<>("schema_name"));
        table.setCellValueFactory(new PropertyValueFactory<>("table_name"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        date.setCellValueFactory(new PropertyValueFactory<>("file_type"));
        batch_details.setItems(summaryObservableList);
    }

    private void setScheduleParam() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_SCHEDULE);
        while (resultSet.next()) {
            scheduleObservableList.add(new ScheduleParameters(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6)));
        }

        schedule_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        minute.setCellValueFactory(new PropertyValueFactory<>("minutes"));
        month.setCellValueFactory(new PropertyValueFactory<>("month"));
        hour.setCellValueFactory(new PropertyValueFactory<>("hours"));
        week_day.setCellValueFactory(new PropertyValueFactory<>("day_of_month"));
        day_month.setCellValueFactory(new PropertyValueFactory<>("day_of_week"));
        schedule_parameters.setItems(scheduleObservableList);
    }

    private void setBatchParameters() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL_PARAMETERS);
        while (resultSet.next()) {
            listItems.add(new BatchParameters(resultSet.getLong(1), resultSet.getLong(2),
                          resultSet.getString(3), resultSet.getLong(4),resultSet.getLong(5)
                         ,resultSet.getLong(6), resultSet.getLong(7), resultSet.getLong(8),
                          resultSet.getInt(9),resultSet.getLong(10), resultSet.getInt(11)
                         ,resultSet.getInt(12),resultSet.getInt(13)));
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        min_value.setCellValueFactory(new PropertyValueFactory<>("minimum_lines"));
        max_value.setCellValueFactory(new PropertyValueFactory<>("maximum_lines"));
        gride_size.setCellValueFactory(new PropertyValueFactory<>("gride_size"));
        thread_number.setCellValueFactory(new PropertyValueFactory<>("number_of_threads"));
        skip_rows.setCellValueFactory(new PropertyValueFactory<>("rows_to_skip"));
        skip_rows.setCellValueFactory(new PropertyValueFactory<>("rows_to_skip"));
        skip_policy.setCellValueFactory(new PropertyValueFactory<>("skip_policy"));
        core_pool_size.setCellValueFactory(new PropertyValueFactory<>("core_pool_size"));
        max_pool_size.setCellValueFactory(new PropertyValueFactory<>("max_pool_size"));
        queue_capacity.setCellValueFactory(new PropertyValueFactory<>("queue_capacity"));
        retry_limit.setCellValueFactory(new PropertyValueFactory<>("retry_limit"));
        keep_alive.setCellValueFactory(new PropertyValueFactory<>("keep_alive_time"));
        batch_parameters.setItems(listItems);
    }
}
