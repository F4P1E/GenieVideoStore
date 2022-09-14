package rmit.team7.teamproject.genievideostore;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public class DeleteItemViewController {
    @FXML
    private ChoiceBox<String> itemListChoice;
    @FXML
    private ListView<Text> itemListView;
    private ArrayList<Customer> customerList;
    private ArrayList<Item> itemList;

    public void generateItemListText() {
        Text[] itemInfo = new Text[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            itemInfo[i].setText(itemList.get(i).itemToString(true));
            itemListView.getItems().add(itemInfo[i]);
        }
    }

    public void onBtDeleteClicked(){
        //added as the main view to return to previous scene after delete
        for(Item currentItem : itemList){
            if(Objects.equals(currentItem.getItemID(), itemListChoice.getSelectionModel().getSelectedItem())){
                itemList.remove(currentItem);
            }

            for(Customer currentCustomer : customerList){
                currentCustomer.getListOfRentedItems().remove(currentItem);
            }
        }
    }
}
