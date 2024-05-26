package com.example.javaweb;


import com.example.javaweb.alem.Router;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("infirmerie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Menu Medecin");
        stage.setScene(scene);
        stage.show();

        /*
        Router.toBegin();**/
    }

    public static void main(String[] args) {
        launch();
    }
}