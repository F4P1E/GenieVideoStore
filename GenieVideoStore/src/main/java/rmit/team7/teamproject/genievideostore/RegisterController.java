package rmit.team7.teamproject.genievideostore;

import javafx.application.Platform;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.synedra.validatorfx.Validator;
import java.sql.Connection;
import java.sql.Statement;

public class RegisterController implements Initializable {
    @FXML
    private Button closeButton;
    @FXML
    private ImageView shieldImageView;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button registerButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldFile = new File("images/icons8-security-lock-48.png");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    public void registerButtonOnEvent(ActionEvent event) {
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            confirmPasswordLabel.setText("You are Set");
            registrationMessageLabel.setText("Customer has been registered successfully!");
        } else {
            confirmPasswordLabel.setText("Password does not match!");
        }
    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerCustomer() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String firstname = firstnameTextField;
        String lastname = lastnameTextField;
        String username = usernameTextField;
        String password = setPasswordField;

        String insertFields = "";
        String insertValues = "";
        String insertToRegister = insertFields + insertValues;
    }
}







