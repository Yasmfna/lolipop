package com.example.javaweb.alem.controller;

import com.example.javaweb.alem.Router;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class Begin implements Initializable {

    @FXML
    private ImageView graphe;

    @FXML
    private ImageView medecin;

    @FXML
    private ProgressBar progressbar;

    @FXML
    private Text titre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AtomicReference<Float> count = new AtomicReference<>((float) 0);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.003), e -> {
                    count.set((float) (count.get() + 0.0005));
                    progressbar.setProgress(count.get());
                })
        );
        timeline.setCycleCount(2000);
        timeline.play();

        timeline.setOnFinished(actionEvent -> {
            Router.toConnexion();
        });

    }
}
