package com.redolf.application.batch.frontend.controller;

import com.jfoenix.controls.JFXButton;
import com.redolf.application.batch.frontend.models.Customer;
import com.redolf.application.batch.backend.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lombok.RequiredArgsConstructor;
import org.controlsfx.control.textfield.CustomTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

import static com.redolf.application.batch.frontend.utils.WindowsUtils.*;
import static com.redolf.application.batch.frontend.validation.Validation.*;

@Component
@RequiredArgsConstructor
public class Driver implements Initializable {

    private UserRepository userRepository;

    private final Customer customer = new Customer();

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private JFXButton btn_sign_in;

    @FXML
    private JFXButton btn_sign_up;

    @FXML
    private TextField confirm_pass_field;

    @FXML
    private Label create_account_label;

    @FXML
    private CustomTextField email_field;

    @FXML
    private Label label_subtext;

    @FXML
    private ProgressIndicator login_progress_indicator;


    @FXML
    private TextField password_field;

    @FXML
    private CustomTextField password_sign_in;

    @FXML
    private Label sign_in_label;

    @FXML
    private JFXButton sign_page;

    @FXML
    private ProgressIndicator sign_up_progress_indicator;

    @FXML
    private Pane slide_pane;

    @FXML
    private CustomTextField username_field;

    @FXML
    private CustomTextField username_sign_in;

    @FXML
    private JFXButton to_sign_in_page;

    @FXML
    private Label welcome_label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        to_sign_in_page.setVisible(false);
    }


    @FXML
    private void onLeftButtonClick(ActionEvent event){
        translateRight(slide_pane,anchorpane);
        setPaneLeftProperties(sign_page,to_sign_in_page,welcome_label,label_subtext);

    }

    @FXML
    private void onRightButtonClick(ActionEvent event){
        translateLeft(slide_pane,anchorpane);
        setPaneRightProperties(sign_page,to_sign_in_page,welcome_label,label_subtext);
    }

    @FXML
    private void closeApplication(MouseEvent event){
        close();
    }

    @FXML
    private void onWindowDragged(MouseEvent event){
        drag(event, anchorpane);
    }

    @FXML
    private void onMousePressed(MouseEvent event){
        press(event, anchorpane);
    }

    @FXML
    private void createUser(ActionEvent event){

        if (!fieldChecker(username_field, USERNAME_PATTERN)){
            username_field.requestFocus();
            noColor(username_field);
        }else if (!fieldChecker(email_field, EMAIL_PATTERN)){
            email_field.requestFocus();
            noColor(email_field);
        }else if (!fieldChecker_(password_field, PASSWORD_PATTERN)){
            password_field.requestFocus();
        }else if (!fieldChecker_(confirm_pass_field, PASSWORD_PATTERN)){
            confirm_pass_field.requestFocus();
        } else{
                if (compareField(password_field, confirm_pass_field)){
                    customer.setUsername(username_field.getText());
                    customer.setEmail(email_field.getText());
                    customer.setPassword(password_field.getText());
                    userRepository.saveAndFlush(customer);
                    translateLeft(slide_pane,anchorpane);
                    setPaneRightProperties(sign_page,to_sign_in_page,welcome_label,label_subtext);
                }
        }
    }
}
