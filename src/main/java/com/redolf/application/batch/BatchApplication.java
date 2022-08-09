package com.redolf.application.batch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.redolf.application.batch.backend.repository")
@ComponentScan(basePackages = "com")
public class BatchApplication extends Application {

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
