package rmit.team7.teamproject.genievideostore.application;

import javafx.application.Application;
import javafx.stage.Stage;
import rmit.team7.teamproject.genievideostore.managers.CredentialsManager;
import rmit.team7.teamproject.genievideostore.managers.ProductsManager;
import rmit.team7.teamproject.genievideostore.managers.ViewController;
import rmit.team7.teamproject.genievideostore.models.Credentials;
import rmit.team7.teamproject.genievideostore.models.Employee;
import rmit.team7.teamproject.genievideostore.models.Product;
import rmit.team7.teamproject.genievideostore.models.User;
import rmit.team7.teamproject.genievideostore.models.Administrator;


public class Main<ActionEvent> extends Application {

    @Override
    public void start(Stage primaryStage) {

        ViewController.getInstance().initAndStart(primaryStage);

        initDefaultConfiguration();

    }

    /**
     * Used to launch the main page activity.
     * @param args is the argument of String array.
     **/
    public static void main(String[] args) {
        launch(args);
    }

    /* used to initialize some users and some products */
    private static void initDefaultConfiguration() {
        Administrator myself = new Administrator("Dong", "Duong", new Credentials("Dong1","123456"));
        User user = new User("Bob", "Smith", new Credentials("bob","1234"));
        Employee employee = new Employee("Alice", "Jones", new Credentials("ali","jS"));

        CredentialsManager.getInstance().signUp(myself);
        CredentialsManager.getInstance().signUp(user);
        CredentialsManager.getInstance().signUp(employee);

        //Insert Product
        Product video1 = new Product("Halo", "Game", 10, 10);
        Product video2 = new Product("Halloween", "DVD", 5, 2);
        Product video3 = new Product("Alpha Dog", "Record", 3, 40);
        Product video4 = new Product("Rat Race", "DVD", 4, 5);
        Product video5 = new Product("White Castle", "Record", 5, 2);
        Product video6 = new Product("Medal Of Honor", "Game", 5, 20);

        //Add Product
        ProductsManager.getInstance().addProduct(video1);
        ProductsManager.getInstance().addProduct(video2);
        ProductsManager.getInstance().addProduct(video3);
        ProductsManager.getInstance().addProduct(video4);
        ProductsManager.getInstance().addProduct(video5);
        ProductsManager.getInstance().addProduct(video6);
    }
}