package rmit.team7.teamproject.genievideostore;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class UpdateCustomerInfoController {
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
    private ChoiceBox customerChosenChoice;
    @FXML
    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();

    @FXML
    public void onChoiceSelectedClicked(){
        String customerChoice = customerChosenChoice.getSelectionModel().getSelectedItem().toString();
        String [] customerChoiceFinding = customerChoice.split(" ");

//        for(Customer currentCustomer : customerList){
//            if(customerChoiceFinding[0].trim() == currentCustomer.getCustomerID() && customerChoiceFinding[1] == currentCustomer.getCustomerName()){
//                if(!nameField.getText().isEmpty())
//                    currentCustomer.setCustomerName(nameField.getText());
//                if(!usernameField.getText().isEmpty())
//                    currentCustomer.setCustomerUsername(usernameField.getText());
//                if(!passwordField.getText().isEmpty())
//                    currentCustomer.setCustomerPassword(passwordField.getText());
//                if(!typeField.getText().isEmpty())
//                    currentCustomer.setCustomerType(typeField.getText());
//                if(!balanceField.getText().isEmpty())
//                    currentCustomer.set(nameField.getText());
//                if(!emailField.getText().isEmpty())
//                    currentCustomer.setCustomerName(emailField.getText());
//                if(!ccNumberField.getText().isEmpty())
//                    currentCustomer.setCustomerName(nameField.getText());
//                if(!nameField.getText().isEmpty())
//                    currentCustomer.setCustomerName(nameField.getText());
            //To be determined after group meeting for selected Customer and Item rework

//      }
    }
}
