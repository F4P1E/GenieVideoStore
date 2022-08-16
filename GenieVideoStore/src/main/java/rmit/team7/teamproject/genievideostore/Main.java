package rmit.team7.teamproject.genievideostore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.synedra.validatorfx.Validator;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("store.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1290, 870);
        stage.setTitle("GenieVideoStore");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}