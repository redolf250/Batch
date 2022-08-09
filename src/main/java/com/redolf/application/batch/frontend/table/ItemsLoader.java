package com.redolf.application.batch.frontend.table;

import com.redolf.application.batch.frontend.DTO.DatabaseData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.redolf.application.batch.frontend.operations.DatabaseTable.getData;
import static com.redolf.application.batch.frontend.utils.WindowsUtils.FXML_NAME;


public class ItemsLoader {

    public static void loadTableItems(VBox items, String filename) throws SQLException {
        URL fxml = null;
        try {
            fxml = new File(FXML_NAME + filename).toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        List<DatabaseData> data = getData();
        Node[] node = new Node[data.size()];
        for (int i = 0; i < node.length; i++) {
            try {
                node[i] = FXMLLoader.load(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            items.getChildren().add(node[i]);
        }
    }
}
