package com.redolf.application.batch.frontend.utils;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WindowsUtils{

    private static double mouseX = 0;
    private static double mouseY = 0;
    public static String FXML_NAME = "D:\\New work\\Batch\\src\\main\\resources\\";
    public static void translateLeft(Pane pane, AnchorPane root){
        TranslateTransition transition = new TranslateTransition(Duration.millis(500),pane);
        transition.setToX(pane.getLayoutX() + (root.getPrefWidth() - pane.getWidth()));
        transition.play();
    }

    public static void translateRight(Pane pane, AnchorPane root){
        TranslateTransition transition = new TranslateTransition(Duration.millis(500),pane);
        transition.setToX(root.getLayoutX());
        transition.play();
    }

    public static void close(){
        System.exit(1);
    }

    public static void setPaneLeftProperties(JFXButton sign_page, JFXButton to_sign_in_page, Label welcome_label, Label label_subtext){
        sign_page.setVisible(true);
        to_sign_in_page.setVisible(false);
        welcome_label.setText("Welcome Back!");
        label_subtext.setText("To keep connected with us, please\n login with your credentials");
    }

    public static void setPaneRightProperties(JFXButton sign_page, JFXButton to_sign_in_page, Label welcome_label, Label label_subtext){
        sign_page.setVisible(false);
        to_sign_in_page.setVisible(true);
        welcome_label.setText("Hello, Friend");
        label_subtext.setText("Enter your personal details and\n start journey with us");
    }

//    public static void minimize(FontIcon fontIcon){
//         Stage stage = (Stage) fontIcon.getScene().getWindow();
//         stage.setIconified(true);
//    }

    public static void drag(MouseEvent event, AnchorPane pane){
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setX(event.getScreenX() - mouseX);
        stage.setY(event.getScreenY() - mouseY);

    }

    public static void press(MouseEvent event, AnchorPane pane){
        mouseX =event.getSceneX();
        mouseY = event.getSceneY();
    }

    public static void loadFxml(StackPane stackpane, String path) throws IOException {
        URL url = null;
        try {
                url = new File(path).toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stackpane.getChildren().removeAll();
        stackpane.getChildren().setAll(root);
    }
}
