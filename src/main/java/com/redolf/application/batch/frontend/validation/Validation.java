package com.redolf.application.batch.frontend.validation;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validation {

    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

    /*
       Password must contain at least one digit [0-9].
       Password must contain at least one lowercase Latin character [a-z].
       Password must contain at least one uppercase Latin character [A-Z].
       Password must contain at least one special character like ! @ # & ( ).
       Password must contain a length of at least 8 characters and a maximum of 20 characters.
   */
    public static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    /*
       Username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.
       Username allowed of the dot (.), underscore (_), and hyphen (-).
       The dot (.), underscore (_), or hyphen (-) must not be the first or last character.
       The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex
       The number of characters must be between 5 to 20.
     */
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public static boolean fieldChecker(CustomTextField textField, String regex){
        Pattern pattern= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(textField.getText().trim());

        return matcher.find();

    }

    public static boolean fieldChecker_(TextField textField, String regex){
        Pattern pattern= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(textField.getText().trim());

        return matcher.find();

    }

    public static void noColor(CustomTextField textField) {
        textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                textField.setStyle("-fx-border-color:none;");
            }
        });
    }

    public static boolean compareField(TextField password, TextField confirm){
        if(password.getText().equals(confirm.getText()))
            return true;
        return false;
    }
}
