package com.redolf.application.batch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("ALL")
@SpringBootApplication
@EntityScan(basePackages = {"com.redolf.application.batch.backend.configs.entity","com.redolf.application.batch.frontend.models"})
@EnableJpaRepositories(basePackages = {"com.redolf.application.batch.backend.repository"
        ,"com.redolf.application.batch.backend.configs.repository"})
@ComponentScan(basePackages = {"com","com.redolf.application.batch.frontend.controller",
        "com.redolf.application.batch.backend.configs"})
@EnableBatchProcessing
public class BatchApplication extends Application{

    public static ConfigurableApplicationContext applicationContext;
    public static Parent root;
    public static Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext = SpringApplication.run(BatchApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(BatchApplication.class.getResource("/dashboard.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
}
