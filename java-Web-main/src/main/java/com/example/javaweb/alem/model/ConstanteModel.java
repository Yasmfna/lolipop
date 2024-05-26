package com.example.javaweb.alem.model;

import com.example.javaweb.alem.core.Help;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.sql.StatementEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConstanteModel {

    private final StringProperty idConstante = new SimpleStringProperty();
    private final StringProperty poids = new SimpleStringProperty();

    private final StringProperty tension = new SimpleStringProperty();

    private final StringProperty taille = new SimpleStringProperty();

    private final StringProperty idCarnet = new SimpleStringProperty();

    private final StringProperty idPersonnel = new SimpleStringProperty();

    private final StringProperty datePriseConstante = new SimpleStringProperty();

    private final StringProperty temperature = new SimpleStringProperty();
    private final StringProperty tauxGlycemie = new SimpleStringProperty();


    public void storeConstante() {

        String sql = "INSERT INTO constantes_patient (poids,tension,taille,idCarnet,idPersonnel,datePriseConstante,temperature,tauxGlycemie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = LoginDB.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1,getPoids());
            preparedStatement.setString(2,getTension());
            preparedStatement.setString(3,getTaille());
            preparedStatement.setString(4,getIdCarnet());
            preparedStatement.setString(5,getIdPersonnel());
            preparedStatement.setTimestamp(6, Help.timestamp());
            preparedStatement.setString(7,getTemperature());
            preparedStatement.setString(8,getTauxGlycemie());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }

    }


    // Setter et getter pour idConstante
    public void setIdConstante(String idConstante) {
        this.idConstante.set(idConstante);
    }

    public String getIdConstante() {
        return idConstante.get();
    }

    public StringProperty idConstanteProperty() {
        return idConstante;
    }

    // Setter et getter pour prenom
    public void setPoids(String poids) {
        this.poids.set(poids);
    }

    public String getPoids() {
        return poids.get();
    }

    public StringProperty poidsProperty() {
        return poids;
    }

    // Setter et getter pour email
    public void setTension(String tension) {
        this.tension.set(tension);
    }

    public String getTension() {
        return tension.get();
    }

    public StringProperty tensionProperty() {
        return tension;
    }

    // Setter et getter pour adresse
    public void setTaille(String taille) {
        this.taille.set(taille);
    }

    public String getTaille() {
        return taille.get();
    }

    public StringProperty tailleProperty() {
        return taille;
    }

    // Setter et getter pour numero
    public void setIdCarnet(String idCarnet) {
        this.idCarnet.set(idCarnet);
    }

    public String getIdCarnet() {
        return idCarnet.get();
    }

    public StringProperty idCarnetProperty() {
        return idCarnet;
    }

    // Setter et getter pour lieuNaissance
    public void setIdPersonnel(String idPersonnel) {
        this.idPersonnel.set(idPersonnel);
    }

    public String getIdPersonnel() {
        return idPersonnel.get();
    }

    public StringProperty idPersonnelProperty() {
        return idPersonnel;
    }

    // Setter et getter pour groupeSanguin
    public void setDatePriseConstante(String datePriseConstante) {
        this.datePriseConstante.set(datePriseConstante);
    }

    public String getDatePriseConstante() {
        return datePriseConstante.get();
    }

    public StringProperty datePriseConstanteProperty() {
        return datePriseConstante;
    }

    // Setter et getter pour dateNaissance
    public void setTemperature(String temperature) {
        this.temperature.set(temperature);
    }

    public String getTemperature() {
        return temperature.get();
    }

    public StringProperty temperatureProperty() {
        return temperature;
    }

    // Setter et getter pour sexe
    public void setTauxGlycemie(String tauxGlycemie) {
        this.tauxGlycemie.set(tauxGlycemie);
    }

    public String getTauxGlycemie() {
        return tauxGlycemie.get();
    }

    public StringProperty tauxGlycemieProperty() {
        return tauxGlycemie;
    }


}
