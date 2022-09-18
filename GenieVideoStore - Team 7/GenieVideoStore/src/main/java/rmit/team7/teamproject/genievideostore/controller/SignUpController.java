package rmit.team7.teamproject.genievideostore.controller;

import java.io.File;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import rmit.team7.teamproject.genievideostore.application.Main;
import rmit.team7.teamproject.genievideostore.managers.AlertManager;
import rmit.team7.teamproject.genievideostore.managers.CredentialsManager;
import rmit.team7.teamproject.genievideostore.managers.ViewController;
import rmit.team7.teamproject.genievideostore.models.Credentials;
import rmit.team7.teamproject.genievideostore.models.Person;

public class SignUpController {

    private static final String FILE_PATH_BACK = "rmit/team7/teamproject/genievideostore/images/back.png";

    /**
     * Used to show the screen.
     **/
    public static void show() {
        try {
            FXMLLoader loaderSignUp = new FXMLLoader();
            loaderSignUp.setLocation(Main.class.getResource("rmit/team7/teamproject/genievideostore/signUp.fxml"));
            AnchorPane rootPane = (AnchorPane) loaderSignUp.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootPane);

            TextField textFieldUsername = (TextField) scene.lookup("#textFieldUsername");
            TextField textFieldPassword = (TextField) scene.lookup("#textFieldPassword");
            TextField textFieldName = (TextField) scene.lookup("#textFieldName");
            TextField textFieldSurname = (TextField) scene.lookup("#textFieldSurname");
            Button bntSignUp = (Button) scene.lookup("#bntSignUp");
            ImageView bntBack = (ImageView) scene.lookup("#back");
            setImageToImageView(bntBack);

            eventHandlerSignUpPage(textFieldUsername, textFieldPassword
                    , textFieldName, textFieldSurname, bntSignUp, bntBack);

            ViewController.getInstance().setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* used to handle sign up page events that occurs */
    private static void eventHandlerSignUpPage(TextField textFieldUsername, TextField textFieldPassword
            ,TextField textFieldName, TextField textFieldSurname, Button bntSignUp, ImageView bntBack) {

        bntSignUp.setOnAction(new EventHandler<>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {
                Person person = new Person(textFieldName.getText(), textFieldSurname.getText(),
                        new Credentials(textFieldUsername.getText(), textFieldPassword.getText()));
                if(!CredentialsManager.getInstance().signUp(person))
                    AlertManager.getInstance().showErrorMessage("Some fields filled are not correct!");
                else {
                    AlertManager.getInstance().showInfoMessage("You registered! Now log in.");;
                    ViewController.getInstance().showLayout(ViewController.START_PAGE);
                }
            }
        });

        bntBack.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ViewController.getInstance().showLayout(ViewController.START_PAGE);
            }
        });

    }

    private static void setImageToImageView(ImageView bntBack){
        File file = new File(FILE_PATH_BACK);
        Image image = new Image(file.toURI().toString());
        bntBack.setImage(image);
    }
}
