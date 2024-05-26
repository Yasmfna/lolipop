package com.example.javaweb.alem.core;

import com.example.javaweb.HelloApplication;
import com.example.javaweb.alem.model.LoginDB;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Help {

    private static final LoginDB loginDB = LoginDB.getInstance();

   //Groupe Sanguin

    public static ObservableList<String> groupeSanguinListe() {
        ListProperty<String> list = new SimpleListProperty<>(FXCollections.observableArrayList());
        String query = "SELECT * FROM groupe_sanguin";

        try (PreparedStatement statement = loginDB.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString("id_groupe_sanguin"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     *
     * @param dateToConvert
     * @return La date sous une forme adapté à sql
     */
    public static String dateFormater(String dateToConvert){
        LocalDate date = LocalDate.parse(dateToConvert);

        // Formatter la date dans un autre format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return date.format(formatter);
    }

    public static Timestamp timestamp (){
        return new Timestamp(System.currentTimeMillis());
    }

}
