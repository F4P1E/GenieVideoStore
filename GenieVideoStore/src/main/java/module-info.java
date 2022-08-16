module rmit.team7.teamproject.genievideostore {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires net.synedra.validatorfx;

    opens rmit.team7.teamproject.genievideostore to javafx.fxml;
    exports rmit.team7.teamproject.genievideostore;
}