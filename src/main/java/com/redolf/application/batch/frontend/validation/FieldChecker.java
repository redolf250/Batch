package com.redolf.application.batch.frontend.validation;


import org.controlsfx.control.textfield.CustomTextField;

import java.util.List;

public class FieldChecker {

    public static void fieldChecker(List<CustomTextField> fields){
        for ( CustomTextField field: fields) {
           field.getText();
        }
    }
}
