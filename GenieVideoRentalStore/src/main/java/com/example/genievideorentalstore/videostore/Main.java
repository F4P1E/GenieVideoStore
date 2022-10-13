package com.example.genievideorentalstore.videostore;

import com.example.genievideorentalstore.model.Customer;
import com.example.genievideorentalstore.model.CustomerQueries;

import java.io.IOException;
import java.io.InputStream;
import java.lang.NullPointerException;
import java.lang.RuntimeException;
import java.lang.Exception;
import java.io.PushbackInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    private final Group root = new Group();
    private static Customer loggedCustomer;

    // for the use of loggedCustomer in the Checkout Page
    private static Main mainInstance;


    public Main() {
        mainInstance = this;
    }
    public static Main getInstance() {
        return mainInstance;
    }

    public Parent createContent() {
        gotoLogin();
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Genie Video Rental Store");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public Customer getLoggedCustomer() {
        return loggedCustomer;
    }

    public boolean userLogging(String userName, String password) throws IOException {
        CustomerQueries customerQueries = new CustomerQueries();
        List<Customer> userNameResults = customerQueries.getCustomerByUserName(userName);
        List<Customer> passwordResults = customerQueries.getCustomerByPassword(password);
        int numberOfCustomersByUserName = userNameResults.size();
        int numberOfCustomersByPassword = passwordResults.size();

        if(numberOfCustomersByUserName != 0 && numberOfCustomersByPassword != 0) {
            int currentCustomerIndex = 0;
            loggedCustomer = userNameResults.get(currentCustomerIndex);
            gotoVideoStore();
            return true;
        } else {
            return false;
        }
    }

    void userLogout() {
        loggedCustomer = null;
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setMinWidth(370);
        primaryStage.setMinHeight(320);
        gotoLogin();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
    }

    public void gotoVideoStore() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        BorderPane store = loader.load();
        MainController mainController = loader.getController();
        mainController.setApp(this);
        root.getChildren().clear();
        root.getChildren().add(store);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        store.prefHeightProperty().bind(primaryStage.heightProperty());
        store.prefWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.setMinWidth(990);
        primaryStage.setMinHeight(730);
        primaryStage.setResizable(false);
    }

    public void gotoRegister() {
        try {
            RegisterController registerController = (RegisterController) replaceSceneContent("Register.fxml");
            registerController.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("Login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream inputStream = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page = null;
        try {
            page = loader.load(InputStream.nullInputStream());
        } catch (NullPointerException e) {
            assert inputStream != null;
            inputStream.close();
        }
        root.getChildren().clear();
        root.getChildren().addAll(page);
        return loader.getController();
    }

}