package rmit.team7.teamproject.genievideostore.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import rmit.team7.teamproject.genievideostore.application.Main;
import rmit.team7.teamproject.genievideostore.managers.AlertManager;
import rmit.team7.teamproject.genievideostore.managers.CredentialsManager;
import rmit.team7.teamproject.genievideostore.managers.ViewController;

import java.io.File;

public class AddEmployeePageController{

    private static final String FILE_PATH_BACK = "rmit/team7/teamproject/genievideostore/images/back.png";

    /**
     * Used to show the screen.
     **/
    public static void show() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("rmit/team7/teamproject/genievideostore/addEmployeePage.fxml"));
            AnchorPane rootPane = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootPane);

            TextField textFieldEmployeeName =(TextField) scene.lookup("#textFieldEmployeeName");
            TextField textFieldEmployeeSurname =(TextField) scene.lookup("#textFieldEmployeeSurname");
            TextField textFieldUsername =(TextField) scene.lookup("#textFieldUsername");
            PasswordField fieldPassword =(PasswordField) scene.lookup("#passwordField");
            Button bntAdd = (Button) scene.lookup("#bntAdd");
            ImageView bntBack = (ImageView) scene.lookup("#bntBack");
            setImageToImageView(bntBack);

            bntBack.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ViewController.getInstance().showLayout(ViewController.ADMINISTRATOR_MAIN_PAGE));

            bntAdd.setOnAction(arg0 -> {
                try {

                    //check if all fields were compiled right
                    if(textFieldEmployeeName.getText().isBlank() || textFieldEmployeeSurname.getText().isBlank()
                            || textFieldUsername.getText().isBlank() || fieldPassword.getText().isBlank()) {
                        AlertManager.getInstance().showErrorMessage("One or more fields filled were not compiled correctly! Retry...");
                        return;
                    }

                    if(CredentialsManager.getInstance().addNewEmployee(textFieldEmployeeName.getText(), textFieldEmployeeSurname.getText(),
                            textFieldUsername.getText(), fieldPassword.getText())) {
                        AlertManager.getInstance().showInfoMessage("Employee added successfully!");
                        ViewController.getInstance().showLayout(ViewController.ADMINISTRATOR_MAIN_PAGE);
                    } else
                        AlertManager.getInstance().showErrorMessage("This username already exists.. please choose another one!");

                } catch(Exception e) {
                    e.printStackTrace();
                    AlertManager.getInstance().showErrorMessage("Something went wrong! Retry...");
                }
            });

            ViewController.getInstance().setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setImageToImageView(ImageView bntBack){
        File file = new File(FILE_PATH_BACK);
        Image image = new Image(file.toURI().toString());
        bntBack.setImage(image);
    }
}