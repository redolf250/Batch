package com.redolf.application.batch.frontend.animation;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class CustomAnimation {
    public static void chartAnimation(PieChart chart) {
        for (PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
                @Override
                public void handle(Event event) {
                    Bounds bounds = data.getChart().getBoundsInLocal();
                    double newX = (bounds.getWidth()) / 5.0 + bounds.getMinX();
                    double newY = (bounds.getHeight()) / 5.0 + bounds.getMinY();
                    data.getNode().setTranslateX(0);
                    data.getNode().setTranslateY(0);
                    TranslateTransition translate = new TranslateTransition(Duration.millis(1500), data.getNode());
                    translate.setByX(newX);
                    translate.setByY(newY);
                    translate.setAutoReverse(true);
                    translate.setCycleCount(2);
                    translate.play();
                }

            });

        }

    }
}
