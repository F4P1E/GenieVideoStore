package rmit.team7.teamproject.genievideostore;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import rmit.team7.teamproject.genievideostore.Customer;
import rmit.team7.teamproject.genievideostore.Item;
import rmit.team7.teamproject.genievideostore.SystemMethods;

import java.util.ArrayList;

public class AddCustomerViewController implements SystemMethods {
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField balanceField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField ccNumberField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField numberOfRentalField;
    @FXML
    private ChoiceBox customerTypeField;
    @FXML
    private TextField customerIDField;
    @FXML
    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();

    @FXML
    public void onBtAddCustomerClicked(){
        //somehow get the customer list from the admin view
        //similar to Account view
        customerList.add(new Customer( customerIDField.getText(), nameField.getText(), addressField.getText(), phoneNumberField.getText(), Integer.parseInt(numberOfRentalField.getText()), customerTypeField.getSelectionModel().getSelectedItem().toString(), usernameField.getText(), passwordField.getText()));
    }
}
