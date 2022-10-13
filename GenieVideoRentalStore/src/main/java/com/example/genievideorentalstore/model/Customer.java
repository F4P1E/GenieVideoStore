package com.example.genievideorentalstore.model;

public class Customer {

    private int customerID;
    private String userName;
    private String email;
    private String password;
    private String ccNumber;
    private double balance;


    public Customer(int customerID, String userName, String email, String password, String ccNumber,double balance) {
        setCustomerID(customerID);
        setUserName(userName);
        setEmail(email);
        setPassword(password);
        setCCNumber(ccNumber);
        setBalance(balance);
    }
    //getCustomerID
    public int getCustomerID() {
        return customerID;
    }
    //setCustomerID
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    //getUserName
    public String getUserName() {
        return userName;
    }
    //setUserName
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //getEmail
    public String getEmail() {
        return email;
    }
    //setEmail
    public void setEmail(String email) {
        this.email = email;
    }
    //getPassword
    public String getPassword() {
        return password;
    }
    //setPassword
    public void setPassword(String password) {
        this.password = password;
    }
    //getCCNumber
    public String getCCNumber() {
        return ccNumber;
    }
    //setCCNumber
    public void setCCNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    //getBalance
    public Double getBalance() {
        return balance;
    }
    //setBalance
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}


