module com.example.javaweb {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.javaweb to javafx.fxml;
    opens com.example.javaweb.alem.controller to javafx.fxml;
    exports com.example.javaweb;
    exports com.example.javaweb.alem;
    exports com.example.javaweb.alem.model;
    exports com.example.javaweb.alem.core;
    opens com.example.javaweb.alem.core;
    opens com.example.javaweb.alem.model;
    exports com.example.javaweb.alem.controller;
    exports com.example.javaweb.alem.controller.infirmerie;
    opens com.example.javaweb.alem to javafx.fxml;
    opens com.example.javaweb.alem.controller.secretariat to javafx.fxml;
    opens com.example.javaweb.alem.controller.infirmerie to javafx.fxml;
    exports com.example.javaweb.alem.controller.secretariat;
    exports com.example.javaweb.alem.model.secretariat;
    opens com.example.javaweb.alem.model.secretariat;


}