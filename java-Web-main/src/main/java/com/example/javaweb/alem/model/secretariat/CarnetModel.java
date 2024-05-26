package com.example.javaweb.alem.model.secretariat;

import com.example.javaweb.alem.core.Help;
import com.example.javaweb.alem.model.LoginDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarnetModel {


    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty prenom = new SimpleStringProperty();

    private final StringProperty email = new SimpleStringProperty();

    private final StringProperty adresse = new SimpleStringProperty();

    private final StringProperty numero = new SimpleStringProperty();

    private final StringProperty lieuNaissance = new SimpleStringProperty();

    private final StringProperty groupeSanguin = new SimpleStringProperty();

    private final StringProperty dateNaissance = new SimpleStringProperty();
    private final StringProperty sexe = new SimpleStringProperty();

    private final StringProperty typePatient = new SimpleStringProperty();

    private final StringProperty profession = new SimpleStringProperty();
    private final StringProperty antecedents = new SimpleStringProperty();

    private final StringProperty message = new SimpleStringProperty();


    //FONCTION D'INSERTION DE CARNET
    public void storeCarnet() throws SQLException {


        //récupération des variables a utiliser
        int idAntecedents = 1;
        //Récupeération de la nouvelle ligne d'antécédents ajouté
        PreparedStatement indexStatement = null;
        try {
            indexStatement = LoginDB.getConnection().prepareStatement("select * from antecedents ORDER BY id_antecedents desc LIMIT 1");
            ResultSet resultSet = indexStatement.executeQuery();
            if(resultSet.next()) {
                idAntecedents = Integer.parseInt(resultSet.getString("id_antecedents"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            indexStatement.close();
        }


        ///ENREGISTREMENT PRELIMINAIRES


        String sql = "INSERT INTO carnet (date_creation_carnet,date_modification_carnet,id_antecedent,localisation,id_sexe,profession,telephone,email,id_groupe_sanguin, date_naissance, lieu_naissance,id_type_patient,nom_prenom,statut_constante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = LoginDB.getConnection().prepareStatement(sql)) {


            preparedStatement.setTimestamp(1, Help.timestamp());
            preparedStatement.setTimestamp(2, Help.timestamp());
            preparedStatement.setInt(3, idAntecedents);
            preparedStatement.setString(4, getAdresse());
            preparedStatement.setString(5, getSexe());
            preparedStatement.setString(6, getProfession());
            preparedStatement.setString(7, getNumero());
            preparedStatement.setString(8, getEmail());
            preparedStatement.setString(9, getGroupeSanguin());
            preparedStatement.setString(10, Help.dateFormater(getDateNaissance()));
            preparedStatement.setString(11, getLieuNaissance());
            preparedStatement.setString(12, getTypePatient());
            preparedStatement.setString(13, getNom() + getPrenom());
            preparedStatement.setInt(14, 0);

            preparedStatement.executeUpdate();


            //ENREGISTRER LES ANTECEDENTS

            //Récupeération de l'id du nouveaau carnet créé pour creer ses antécédents

            indexStatement = LoginDB.getConnection().prepareStatement("select * from carnet ORDER BY id_carnet desc LIMIT 1");
            ResultSet r = indexStatement.executeQuery();
            int idCarnet = 1;
            if(r.next()) {
                idCarnet = Integer.parseInt(r.getString("id_carnet"));
            }


            indexStatement = LoginDB.getConnection().prepareStatement("insert into antecedents (id_carnet,antecedents) values (?,?)");

            //Enregistrement de la nouvelle ligne d'antécédents pour ke nouveau patient

            indexStatement.setInt(1, idCarnet);
            indexStatement.setString(2, getAntecedents());

            indexStatement.execute();

            setMessage("ENREGISTREMENT TERMINE");


        } catch (SQLException e) {
            setMessage("ERREUR D'ENREGISTREMENT");
            throw new RuntimeException(e);
        }finally {
            indexStatement.close();
        }

    }


    // Setter et getter pour nom
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    // Setter et getter pour prenom
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    // Setter et getter pour email
    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    // Setter et getter pour adresse
    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    // Setter et getter pour numero
    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getNumero() {
        return numero.get();
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    // Setter et getter pour lieuNaissance
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance.set(lieuNaissance);
    }

    public String getLieuNaissance() {
        return lieuNaissance.get();
    }

    public StringProperty lieuNaissanceProperty() {
        return lieuNaissance;
    }

    // Setter et getter pour groupeSanguin
    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin.set(groupeSanguin);
    }

    public String getGroupeSanguin() {
        return groupeSanguin.get();
    }

    public StringProperty groupeSanguinProperty() {
        return groupeSanguin;
    }

    // Setter et getter pour dateNaissance
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance.set(dateNaissance);
    }

    public String getDateNaissance() {
        return dateNaissance.get();
    }

    public StringProperty dateNaissanceProperty() {
        return dateNaissance;
    }

    // Setter et getter pour sexe
    public void setSexe(String sexe) {
        this.sexe.set(sexe);
    }

    public String getSexe() {
        return sexe.get();
    }

    public StringProperty sexeProperty() {
        return sexe;
    }

    // Setter et getter pour typePatient
    public void setTypePatient(String typePatient) {
        this.typePatient.set(typePatient);
    }

    public String getTypePatient() {
        return typePatient.get();
    }

    public StringProperty typePatientProperty() {
        return typePatient;
    }

    // Setter et getter pour profession
    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public String getProfession() {
        return profession.get();
    }

    public StringProperty professionProperty() {
        return profession;
    }

    // Setter et getter pour Antecedents
    public void setAntecedents(String antecedents) {
        this.antecedents.set(antecedents);
    }

    public String getAntecedents() {
        return antecedents.get();
    }

    public StringProperty antecedentsProperty() {
        return antecedents;
    }

    // Setter et getter pour message
    public void setMessage(String message) {
        this.antecedents.set(message);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }


}
