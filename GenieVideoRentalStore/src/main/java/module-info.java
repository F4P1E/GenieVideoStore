module com.example.genievideorentalstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
    requires org.kordamp.ikonli.javafx;

    opens com.example.genievideorentalstore.videostore to javafx.fxml;
    exports com.example.genievideorentalstore.videostore;
}