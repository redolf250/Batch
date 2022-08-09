package com.redolf.application.batch.frontend.utils;

import com.redolf.application.batch.backend.models.Datasource_;

import java.sql.SQLException;
import java.util.List;

import static com.redolf.application.batch.backend.service.DatasourceService.findByName;

public class MyDriver {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List r = findByName("MariaD");
        if (r.size()==1){
            System.out.println("Helllll");
        }else {
            System.out.println("dfhgdfhgdf");
        }


    }
}
