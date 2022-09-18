package rmit.team7.teamproject.genievideostore.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import rmit.team7.teamproject.genievideostore.application.Main;
import rmit.team7.teamproject.genievideostore.managers.AlertManager;
import rmit.team7.teamproject.genievideostore.managers.CredentialsManager;
import rmit.team7.teamproject.genievideostore.managers.ViewController;


public class LoginPageController{

    /**
     * Used to show the screen.
     **/
    public static void show() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loaderStart = new FXMLLoader();
            loaderStart.setLocation(Main.class.getResource("rmit/team7/teamproject/genievideostore/main.fxml"));
            AnchorPane rootPane = loaderStart.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootPane);

            TextField textFieldUsername = (TextField) scene.lookup("#textFieldUsername");
            PasswordField passwordField = (PasswordField) scene.lookup("#passwordField");
            Button bntLogin = (Button) scene.lookup("#bntLogin");
            Button bntSignUp = (Button) scene.lookup("#bntSignUp");

            eventHandlerStartPage(textFieldUsername, passwordField, bntLogin, bntSignUp);

            ViewController.getInstance().setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* used to handle start page events that occurs */
    private static void eventHandlerStartPage(TextField textFieldUsername, PasswordField passwordField,
                                              Button bntLogin, Button bntSignUp) {

        bntLogin.setOnAction(arg0 -> {
            if(!CredentialsManager.getInstance().logIn( textFieldUsername.getText(), passwordField.getText())) {
                AlertManager.getInstance().showErrorMessage("Credentials entered is not correct!");
                return;
            }

            switch (CredentialsManager.getInstance().getTypeOfPersonLoggedIn()) {
                case CredentialsManager.USER -> {
                    ViewController.getInstance().showLayout(ViewController.USER_MAIN_PAGE);
                    return;
                }
                case CredentialsManager.EMPLOYEE -> {
                    ViewController.getInstance().showLayout(ViewController.EMPLOYEE_MAIN_PAGE);
                    return;
                }
                case CredentialsManager.ADMINISTRATOR -> {
                    ViewController.getInstance().showLayout(ViewController.ADMINISTRATOR_MAIN_PAGE);
                    return;
                }
            }
        });

        bntSignUp.setOnAction(new EventHandler<>() {

            @Override
            public void handle(javafx.event.ActionEvent arg0) {
                ViewController.getInstance().showLayout(ViewController.SIGN_UP_PAGE);
            }
        });
    }

}
