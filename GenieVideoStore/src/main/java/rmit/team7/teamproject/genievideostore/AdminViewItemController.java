package rmit.team7.teamproject.genievideostore;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AdminViewItemController extends AdminSceneController implements SystemMethods{
    @FXML
    private Pane leftPane;
    @FXML
    private Pane rightPane;
    @FXML
    private Text itemSetting;
    @FXML
    private ListView<Text> itemView;
    @FXML
    private Button btAddNewItem;
    @FXML
    private Button btUpdateCurrentItem;
    @FXML
    private TextField itemSearchField;
    @FXML
    private Button btSearch;
    @FXML
    private Text matchIndicator;
    @FXML
    private Button btDeleteItem;
    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Item> itemList = new ArrayList<>();


    /* -------------------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------------------- */
    /* ------------------------------ ITEM SETTING PATHWAY ---------------------------------- */
    /* -------------------------------------------------------------------------------------- */
    /* -------------------------------------------------------------------------------------- */

    /* -------------------------- DISPLAY ALL ITEM PATHWAY ---------------------------------- */

    public void generateItemListText() {
        Text[] itemInfo = new Text[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            itemInfo[i].setText(itemList.get(i).itemToString(true));
            itemView.getItems().add(itemInfo[i]);
        }
    }

    /* -------------------------- SEARCH FOR ITEM PATHWAY ---------------------------------- */
    @FXML
    public void onSearchForItemClicked(){
        CharSequence itemSearchStr = itemSearchField.getText();
        int matchFound = 0;
        Text matchIndicator = new Text();

        rightPane.getChildren().add(matchIndicator);
        itemView.getItems().clear();

        for (Item currentItem : itemList) {
            if (currentItem.getItemTitle().contains(itemSearchStr) || currentItem.getItemID().contains(itemSearchStr)) {
                itemView.getItems().add(new Text(currentItem.itemToString(true)));
                matchFound++;
            }
        }

        if (matchFound > 1)
            matchIndicator.setText("Found" + matchFound + " matches");
        else
            matchIndicator.setText("Found" + matchFound + " match");
    }
    //calls similar search engine as CUSTOMER SETTING


    /* -------------------------- ADD NEW ITEM PATHWAY ---------------------------------- */

    /* -------------------------- UPDATE CURRENT ITEM PATHWAY ---------------------------------- */
    // Switch to another view to edit and update itemList


    /* -------------------------- DELETE ITEM PATHWAY ---------------------------------- */
    // Switch to another view to view all items and able to choose to delete each one
}

