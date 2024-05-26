package com.example.javaweb.alem.controller.infirmerie;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.javaweb.alem.controller.Constantes;
import com.example.javaweb.alem.core.SendButton;
import com.example.javaweb.alem.model.secretariat.PatientConsultations;
import com.example.javaweb.alem.model.secretariat.PatientInfirmerie;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Accueil implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label constantesText;

    @FXML
    private TableView<PatientInfirmerie> tableConstante;

    @FXML
    private TableView<PatientConsultations> tableConsultations;

    @FXML
    void initialize() {
        assert constantesText != null : "fx:id=\"constantesText\" was not injected: check your FXML file 'infirmerie.fxml'.";
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Table Constante

        // Création des cellules pour les colonnes de la table
        tableConstante.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idPatient"));
        tableConstante.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
        tableConstante.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sexePatient"));
        tableConstante.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dernierRdv"));

        // Ajouter la colonne de CheckBox
        TableColumn<PatientInfirmerie, Boolean> colCheckBox = new TableColumn<>("Statut");
        colCheckBox.setCellValueFactory(cellData -> {
            PatientInfirmerie patient = cellData.getValue();
            return new SimpleBooleanProperty(patient.getStatutConstante().equals("0"));
        });

        colCheckBox.setCellFactory(column -> new TableCell<>() {
            private final CheckBox checkBox = new CheckBox();

            {
                checkBox.setOnAction(event -> {
                    PatientInfirmerie patient = getTableView().getItems().get(getIndex());
                    if (checkBox.isSelected()) {
                        patient.enregistrerConstantes();
                        getTableView().getItems().remove(patient);
                    }
                });
            }

            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(checkBox);
                    checkBox.setSelected(item);
                }
            }
        });

        tableConstante.getColumns().add(colCheckBox);

        // Ajouter la colonne avec le bouton "Enregistrer"
        TableColumn<PatientInfirmerie, Void> buttonColumn = new TableColumn<>("Enregistrer");
        buttonColumn.setCellFactory(col -> new TableCell<>() {
            private final Button button = new Button("Enregistrer");

            {
                button.setOnAction(event -> {
                    PatientInfirmerie patient = getTableView().getItems().get(getIndex());
                    patient.enregistrerConstantes();
                    getTableView().getItems().remove(patient);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        tableConstante.getColumns().add(buttonColumn);

        // Ajouter la colonne avec le bouton "Remplir"
        TableColumn<PatientInfirmerie, Void> remplirColumn = new TableColumn<>("Constante");
        remplirColumn.setCellFactory(col -> new TableCell<>() {
            private final Button button = new Button("Remplir");

            {
                button.setOnAction(event -> {
                    PatientInfirmerie patient = getTableView().getItems().get(getIndex());
                    // Code pour charger le nouvel FXML
                    loadRemplirView(patient);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        tableConstante.getColumns().add(remplirColumn);

        // Charger les patients avec statut constante 0
        tableConstante.setItems(PatientInfirmerie.getPatientsWithStatutConstanteZero());

        // Redirection vers la prise de constantes
        constantesText.setOnMouseClicked(mouseEvent -> {
            // Logique pour la redirection
        });


        // Table Consultations
        // Création des cellules pour les colonnes de la tableSoins
        tableConsultations.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idPatient"));
        tableConsultations.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
        tableConsultations.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sexePatient"));
        tableConsultations.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dernierRdv"));



    // Charger les patients avec statut constante 1
        tableConsultations.setItems(PatientConsultations.getPatientsWithStatutConstanteUn());

}

    private void loadRemplirView(PatientInfirmerie patient) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javaweb/yeoviews/form_infirmier.fxml"));
            Parent root = loader.load();

            // Passer des données au contrôleur de la nouvelle vue si nécessaire
            Constantes controller = loader.getController();
            controller.setPatient(patient);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

