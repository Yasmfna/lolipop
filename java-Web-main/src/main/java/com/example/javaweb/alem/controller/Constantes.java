package com.example.javaweb.alem.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.javaweb.alem.model.ConstanteModel;
import com.example.javaweb.alem.model.secretariat.PatientInfirmerie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Constantes implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField frequenceTextField;

    @FXML
    private TextField glycemieTextField;

    @FXML
    private TextArea noteTextArea;

    @FXML
    private TextField poidsTextField;

    @FXML
    private TextField pressionArtTextField;

    @FXML
    private Button storeConstanteButton;

    @FXML
    private TextField tailleTextField;

    @FXML
    private TextField tempTextField;

    @FXML
    private TextField tensionTextField;

    private static final ConstanteModel constanteModel = new ConstanteModel();

    private PatientInfirmerie patient;

    public void setPatient(PatientInfirmerie patient) {
        this.patient = patient;
        // Initialiser les champs avec les données du patient si nécessaire
    }

    @FXML
    void initialize() {
        assert frequenceTextField != null : "fx:id=\"frequenceTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert glycemieTextField != null : "fx:id=\"glycemieTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert noteTextArea != null : "fx:id=\"noteTextArea\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert poidsTextField != null : "fx:id=\"poidsTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert pressionArtTextField != null : "fx:id=\"pressionArtTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert storeConstanteButton != null : "fx:id=\"storeConstanteButton\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert tailleTextField != null : "fx:id=\"tailleTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert tempTextField != null : "fx:id=\"tempTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";
        assert tensionTextField != null : "fx:id=\"tensionTextField\" was not injected: check your FXML file 'form_infirmier.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void setIdCarnet(String id){
        constanteModel.setIdCarnet(id);
    }
}