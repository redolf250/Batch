package com.redolf.application.batch.frontend.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.redolf.application.batch.frontend.utils.WindowsUtils.FXML_NAME;

public class Window {


    public static void loadWindow(String path) throws IOException {
        URL url = new File(FXML_NAME+path).toURI().toURL();
        Parent root =  FXMLLoader.load(url);
        Stage stage = new Stage();
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
