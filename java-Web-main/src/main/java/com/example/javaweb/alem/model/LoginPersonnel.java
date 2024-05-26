package com.example.javaweb.alem.model;

import com.example.javaweb.alem.Router;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPersonnel {


    private static final LoginDB loginDB = LoginDB.getInstance();
    private static final ListProperty<LoginPersonnel> listPatient = new SimpleListProperty<>(FXCollections.observableArrayList());
    // Donnees utilisées pour la connexion
    private final StringProperty login = new SimpleStringProperty();
    private final StringProperty motDePasse = new SimpleStringProperty();
    private final StringProperty personnel = new SimpleStringProperty();

    private LoginPersonnel(String login, String password, String statut) {
        this.login.set(login);
        this.motDePasse.set(password);
        this.personnel.set(statut);
    }

    public static LoginPersonnel getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * La fonction doit trouver le personnel en fonction de ces données entrées
     *
     * @return
     */
    public String findPersonnel(String login, String password, String statutPersonnel) {

        //requête de recherche du personnel

        String query = "SELECT * FROM personnel WHERE login = ? AND mot_de_passe = ?";


        try (PreparedStatement statement = loginDB.getConnection().prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);


            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getString("type_personnel"));

                if (resultSet.getString("type_personnel").equals("secretaire")) {
                    Router.toAccueil();
                } else if (resultSet.getString("type_personnel").equals("infirmier") || resultSet.getString("type_personnel").equals("infirmiere")) {
                    Router.toInfirmerie();
                }

            }

        } catch (Exception e) {
            return e.getMessage();
        }

        return "";

    }

    public String getPersonnel() {
        return personnel.get();
    }

    public void setPersonnel(String personnel) {
        this.personnel.set(personnel);
    }

    public StringProperty personnelProperty() {
        return personnel;
    }

    public String getMot_de_pass_accueil() {
        return motDePasse.get();
    }

    public void setMot_de_pass_accueil(String mot_de_pass_accueil) {
        this.motDePasse.set(mot_de_pass_accueil);
    }

    public StringProperty mot_de_pass_accueilProperty() {
        return motDePasse;
    }

    public String getLogin_accueil() {
        return login.get();
    }

    public void setLogin_accueil(String login_accueil) {
        this.login.set(login_accueil);
    }

    public StringProperty login_accueilProperty() {
        return login;
    }

    private static class Holder {
        private static final LoginPersonnel INSTANCE = new LoginPersonnel("", "", "");
    }
}
