package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import org.controlsfx.control.textfield.CustomTextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Home implements Initializable {

    @FXML
    private Label batch_id;

    @FXML
    private static BorderPane borderpane;

    @FXML
    private AnchorPane borderpane_content;

    @FXML
    private Label database;

    @FXML
    private Label date;

    @FXML
    private Label file_type;

    @FXML
    private HBox hearder_hbox;

    @FXML
    private AnchorPane left_anchorpane;

    @FXML
    private JFXListView<Label> listview;

    @FXML
    private Pane rollback_pane;

    @FXML
    private Label rollback_text;

    @FXML
    private Label rollback_value;

    @FXML
    private Pane rootpane;

    @FXML
    private Label schema;

    @FXML
    private CustomTextField search_box;

    @FXML
    private ScrollPane items;

    @FXML
    private Label status;

    @FXML
    private Pane sucessful_pane;

    @FXML
    private Label sucessful_text;

    @FXML
    private Label sucessful_value;

    @FXML
    private HBox table_header;

    @FXML
    private Pane update_pane;

    @FXML
    private Label update_text;

    @FXML
    private Label update_value;

    @FXML
    private VBox listItems;


    public static BorderPane myPane = borderpane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < 40; i++) {
            Label label = new Label(" Redolf \n 0552588647");
            listview.getItems().add(label);
        }

        listview.setExpanded(true);
        listview.setDepth(2);
        listview.depthProperty().set(1);
    }
 }
