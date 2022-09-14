package rmit.team7.teamproject.genievideostore;

import java.util.ArrayList;

public class Item {
    private String itemID;
    private String itemTitle;
    private String itemRentType;
    private String itemLoanType;
    private int itemNumberOfCopies;
    private double itemFee;
    private String genre;
    private static ArrayList<Item> itemList;

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemRentType(String itemRentType) {
        this.itemRentType = itemRentType;
    }

    public void setItemLoanType(String itemLoanType) {
        this.itemLoanType = itemLoanType;
    }

    public void setItemNumberOfCopies(int itemNumberOfCopies) {
        this.itemNumberOfCopies = itemNumberOfCopies;
    }

    public void setItemFee(double itemFee) {
        this.itemFee = itemFee;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Item(String itemID, String itemTitle, String itemRentType, String itemLoanType, int itemNumberOfCopies, double itemFee, String genre) {
        this.itemID = itemID;
        this.itemTitle = itemTitle;
        this.itemRentType = itemRentType;
        this.itemLoanType = itemLoanType;
        this.itemNumberOfCopies = itemNumberOfCopies;
        this.itemFee = itemFee;
        this.genre = genre;
    }

    public Item(String itemID, String itemTitle, String itemRentType, String itemLoanType, int itemNumberOfCopies, double itemFee) {
        this.itemID = itemID;
        this.itemTitle = itemTitle;
        this.itemRentType = itemRentType;
        this.itemLoanType = itemLoanType;
        this.itemNumberOfCopies = itemNumberOfCopies;
        this.itemFee = itemFee;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String itemToString(boolean nameAndIDOnly){
        StringBuilder itemText = new StringBuilder();

        itemText.append(this.itemID + ", ");
        itemText.append(this.itemTitle);

        if(!nameAndIDOnly){
            itemText.append(", " + this.itemRentType + ", ");
            itemText.append(this.itemLoanType + ", ");
            itemText.append(this.itemNumberOfCopies + ", ");
            itemText.append(this.itemFee + ", ");
            itemText.append(this.genre);
        }

        return itemText.toString();
    }
}
