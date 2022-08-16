package rmit.team7.teamproject.genievideostore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class LoginController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;

    public void loginButtonOnAction(ActionEvent event){
        loginMessageLabel.setText("You Try To Login");
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}