module rmit.team.teamproject.genievideostore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    exports rmit.team7.teamproject.genievideostore.controller;
    opens rmit.team7.teamproject.genievideostore.controller to javafx.fxml;
    exports rmit.team7.teamproject.genievideostore.classes;
    opens rmit.team7.teamproject.genievideostore.classes to javafx.fxml;
    exports rmit.team7.teamproject.genievideostore.managers;
    opens rmit.team7.teamproject.genievideostore.managers to javafx.fxml;
    exports rmit.team7.teamproject.genievideostore.models;
    opens rmit.team7.teamproject.genievideostore.models to javafx.fxml;
    exports rmit.team7.teamproject.genievideostore.application;
    opens rmit.team7.teamproject.genievideostore.application to javafx.fxml;
}