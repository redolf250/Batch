package com.redolf.application.batch.frontend.operations;

import com.redolf.application.batch.frontend.DTO.DatabaseData;
import com.redolf.application.batch.frontend.connection.DbConnection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.redolf.application.batch.backend.queries.Queries.SELECT_ALL_DATASOURCE;

@Component
public class DatabaseTable {
    static Connection connection;

    static {
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static ResultSet resultSet;

    static {
        try {
            resultSet = connection.createStatement().executeQuery(SELECT_ALL_DATASOURCE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<DatabaseData> data = new ArrayList<>();

    public DatabaseTable() {
    }

    public static List<DatabaseData> getData() throws SQLException {
        while (resultSet.next()) {
            data.add(new DatabaseData(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4),resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),
                    resultSet.getString(8),resultSet.getString(9),resultSet.getString(10)));
        }
        System.out.println("Updated result set");
        return data;
    }
}
