package com.redolf.application.batch.frontend.controller;

import com.redolf.application.batch.frontend.DTO.DatabaseData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.operations.DatabaseTable.getData;


public class DatabaseItems implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label db_host;

    @FXML
    private Label db_id;

    @FXML
    private Label db_port;

    @FXML
    private HBox table_header;

    @FXML
    private Label vendor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadItems() throws SQLException {
        List<DatabaseData> data =  getData();
//        for (DatabaseData item : data) {
//
//            System.out.println(item);
//        }

        for (int i = 0; i < data.size(); i++) {
        }
    }
}
