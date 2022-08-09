package com.redolf.application.batch.frontend.operations;

import com.redolf.application.batch.frontend.DTO.DatabaseData;
import com.redolf.application.batch.frontend.connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.redolf.application.batch.frontend.operations.DatabaseTable.getData;

public class Helper {
    public static int count(String query) {
        PreparedStatement ps;
        int CSV_VALUE;
        try {
            Connection connection = DbConnection.getConnection();
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            CSV_VALUE = 0;
            while (resultSet.next()) {
                CSV_VALUE++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return CSV_VALUE;
    }

    static List<String> db_drivers = new ArrayList<>();
    public static List<String> getDriverClass() throws SQLException {
        List<DatabaseData> data =  getData();
        for (DatabaseData items : data) {
            db_drivers.add(items.getDriver_name());
        }
        return db_drivers;
    }
}
