package rmit.team7.teamproject.genievideostore;

import java.util.LinkedHashSet;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private int numberOfRental;
    private String customerType;
    private String customerUsername;
    private String customerPassword;
    private LinkedHashSet<Item> listOfRentedItems;

    public Customer(String customerID, String customerName, String customerAddress, String customerPhone, int numberOfRental, String customerType, String customerUsername, String customerPassword) {
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setNumberOfRental(int numberOfRental) {
        this.numberOfRental = numberOfRental;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void setListOfRentedItems(LinkedHashSet<Item> listOfRentedItems) {
        this.listOfRentedItems = listOfRentedItems;
    }

    public LinkedHashSet<Item> getListOfRentedItems() {
        return listOfRentedItems;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customer(String customerID, String customerName, String customerAddress, String customerPhone, int numberOfRental, String customerType, String customerUsername, String customerPassword, LinkedHashSet<Item> listOfRentedItems) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.numberOfRental = numberOfRental;
        this.customerType = customerType;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    public String customerToString(boolean nameAndIDOnly){
        StringBuilder customerText = new StringBuilder();

        customerText.append(this.customerID + ", ");
        customerText.append(this.customerName);

        if(!nameAndIDOnly){
            customerText.append(", " + this.customerAddress + ", ");
            customerText.append(this.customerPhone + ", ");
            customerText.append(this.numberOfRental + ", ");
            customerText.append(this.customerType + ", ");
            customerText.append(this.customerUsername + ", ");
            customerText.append(this.customerPassword);
        }

        return customerText.toString();
    }
}

