package com.example.BigPiggie;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("PIG");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        controller.setStage();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}