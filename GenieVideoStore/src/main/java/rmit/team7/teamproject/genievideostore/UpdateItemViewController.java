//package rmit.team7.teamproject.genievideostore;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.TextField;
//import javafx.scene.text.Text;
//
//import java.util.ArrayList;
//
//public class UpdateItemViewController implements SystemMethods {
//    @FXML
//    private TextField itemIDField;
//    @FXML
//    private TextField titleField;
//    @FXML
//    private ChoiceBox rentTypeChoice;
//    @FXML
//    private ChoiceBox loanTypeChoice;
//    @FXML
//    private TextField numberOfRentalField;
//    @FXML
//    private TextField rentalFeeField;
//    @FXML
//    private ChoiceBox genreField;
//    @FXML
//    private Text errorMessage;
//
//    private ArrayList<Customer> customerList = new ArrayList<>();
//    private ArrayList<Item> itemList = new ArrayList<>();
//
//    @FXML
//    public void onBtAddItemClicked(){
//        //added to the View itself, not the controller since adding an item will change scene
//        while (true) {
//            if(itemIDField.getText().matches("^I\\d{3}-\\d{4}");
//                break;
//            errorMessage.setText("ID does not match required field: I###-YYYY.");
//            return;
//        }
//
//        while (true) {
//            if(titleField.getText().length() < 30)
//                break;
//            errorMessage.setText("Title should not be longer than 30 characters.");
//            return;
//        }
//
//        while(true){
//            if(!rentTypeChoice.getSelectionModel().isEmpty())
//                break;
//            errorMessage.setText("Rental type cannot be empty.");
//            return;
//        }
//
//        while(true){
//            if(!loanTypeChoice.getSelectionModel().isEmpty())
//                break;
//            errorMessage.setText("Loan type cannot be empty.");
//            return;
//        }
//
//        while(true){
//            if(numberOfRentalField.getText().matches("^\\d{3}"))
//                break;
//            errorMessage.setText("Number of copies is not correct or exceeds limit.");
//            return;
//        }
//
//        while(true){
//            if(rentalFeeField.getText().matches("^\\d{3}"))
//                break;
//            errorMessage.setText("Rental fee is not correct or exceeds limit.");
//            return;
//        }
//
//        while(true){
//            if((rentTypeChoice.getSelectionModel().getSelectedItem() == "DVD" || rentTypeChoice.getSelectionModel().getSelectedItem() == "DVD") && !genreField.getSelectionModel().isEmpty())
//                break;
//            errorMessage.setText("Error with rent type and genre selection.");
//        }
//
//        if(rentTypeChoice.getSelectionModel().getSelectedItem() == "Game"){
//            itemList.add(new Item(itemIDField.getText(), titleField.getText(), rentTypeChoice.getSelectionModel().getSelectedItem().toString(), loanTypeChoice.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(numberOfRentalField.getText()), Integer.parseInt((rentalFeeField.getText()))));
//        }
//        else if(rentTypeChoice.getSelectionModel().getSelectedItem() == "DVD" || rentTypeChoice.getSelectionModel().getSelectedItem() == "Record"){
//            itemList.add(new Item(itemIDField.getText(), titleField.getText(), rentTypeChoice.getSelectionModel().getSelectedItem().toString(), loanTypeChoice.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(numberOfRentalField.getText()), Integer.parseInt((rentalFeeField.getText())), genreField.getSelectionModel().getSelectedItem().toString()));
//        }
//    }
//}
