package rmit.team7.teamproject.genievideostore;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmit.team7.teamproject.genievideostore.Customer;
import rmit.team7.teamproject.genievideostore.Item;
import rmit.team7.teamproject.genievideostore.SystemMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AdminViewCustomerController implements SystemMethods {
    @FXML
    private Pane leftPane;
    @FXML
    private Pane rightPane;
    @FXML
    private Text cusSetting;
    @FXML
    private ListView<Text> customerView;
    @FXML
    private Button btAddNewCus;
    @FXML
    private Button btUpdateCurrentCus;
    @FXML
    private TextField cusSearchField;
    @FXML
    private Button btSearch;
    @FXML
    private Text matchIndicator;

    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();

    public void generateCustomerListText() {
        Text[] customerInfo = new Text[customerList.size()];

        for (int i = 0; i < customerList.size(); i++) {
            customerInfo[i].setText(customerList.get(i).customerToString(true));
            customerView.getItems().add(customerInfo[i]);
        }
    }

    /* -------------------------- DISPLAY INFO PATHWAY ---------------------------------- */
//    @FXML
//    public void onDisplayViewBackClicked(){
//        rightPane.getChildren().clear();
//        rightPane.getChildren().addAll(cusSetting, btAddNewCus, btUpdateCurrentCus);
//    }

    /* -------------------------- SEARCH FOR CUSTOMER PATHWAY ---------------------------------- */
    // C0*** is ID. A-Z* is Name
    @FXML
    public void onSearchForCustomerClicked() {
        //display TextField and an empty VBOX pane
        CharSequence customerSearchStr = cusSearchField.getText();
        int matchFound = 0;
        Text matchIndicator = new Text();

        rightPane.getChildren().add(matchIndicator);

        for (Customer currentCustomer : customerList) {
            if (currentCustomer.getCustomerName().contains(customerSearchStr) || currentCustomer.getCustomerID().contains(customerSearchStr)) {
                rightPane.getChildren().add(new Text(currentCustomer.customerToString(true)));
                matchFound++;
            }
        }

        if (matchFound > 1)
            matchIndicator.setText("Found" + matchFound + " matches");
        else
            matchIndicator.setText("Found" + matchFound + " match");
    }

    public void displaySummaryCustomerInfo(String identifier, boolean isCustomer, boolean isID) {
        //search based on the identifier string, based on true of false boolean
    }

    //calls back majority of the method on DISPLAY ALL CUSTOMER, as a form of edit

    /* -------------------------- ADD NEW CUSTOMER PATHWAY ---------------------------------- */
    @FXML
    public void onAddNewCustomerClicked(Stage stage, Pane addNewCustomerPane) {
        //switches pane into a separate TextField and fill out information to be added to the Array
        //adds this info into the Array to be later updated in the text file
        //Uses similar function to Profile to edit current information
        //use this button in main()
            stage.getScene().setRoot(leftPane.getParent());

            btAddNewCus.setOnMouseClicked(mouseEvent -> {
            stage.getScene().setRoot(addNewCustomerPane);
        });
    }

    @FXML
    public void onUpdateCustomerInfoClicked(){
        //design similar to "Profile" design from standard user and apply it to Admin view
    }

    @FXML
    public void onBtBackClicked(){}
    //calls back DISPLAY ALL CUSTOMER onBackEditViewClicked in cases of cancellation
}


