package com.application.table;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.application.utils.WindowsUtils.FXML_NAME;

public class ItemsLoader {

    public static void loadTableItems(VBox items, String filename) {
        URL fxml = null;
        try {
            fxml = new File(FXML_NAME + filename).toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Node[] node = new Node[20];
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
