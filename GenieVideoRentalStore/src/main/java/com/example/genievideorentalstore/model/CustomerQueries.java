package com.example.genievideorentalstore.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/video_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private PreparedStatement selectCustomerByUserName;
    private PreparedStatement selectCustomerByPassword;
    private PreparedStatement insertNewCustomer;

    public CustomerQueries() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectCustomerByUserName = connection.prepareStatement("SELECT * FROM customers WHERE UserName = ?");
            selectCustomerByPassword = connection.prepareStatement("SELECT * FROM customers WHERE Password = ?");
            insertNewCustomer = connection.prepareStatement("INSERT INTO  customers " + " (UserName, Password, Email, CCNumber) " + "VALUES (?, ?, ?, ?)");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<Customer> getCustomerByUserName(String userName) {
        List<Customer> results = null;
        ResultSet resultSet = null;

        try {
            selectCustomerByUserName.setString(1, userName);

            // executeQuery returns a ResultSet that contains the desired records
            resultSet = selectCustomerByUserName.executeQuery();

            results = new ArrayList<Customer>();

            while (resultSet.next()) {
                results.add(new Customer(
                        resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(resultSet).close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // Selects Customer with Password for Login Form
    public List<Customer> getCustomerByPassword(String password) {
        List<Customer> results = null;
        ResultSet resultSet = null;

        try {
            selectCustomerByPassword.setString(1, password);

            // executeQuery returns a ResultSet that contains the desired records
            resultSet = selectCustomerByPassword.executeQuery();

            results = new ArrayList<Customer>();

            while (resultSet.next()) {
                results.add(new Customer(resultSet.getInt("customerID"),
                        resultSet.getString("userName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("ccNumber"),
                        resultSet.getDouble("balance"))
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }

        return results;
    }

    // Insert new Customer for Register Form
    public void addCustomer(String userName, String password, String email, String ccNumber) {
        int result = 0;

        // defines parameters and then runs insertNewCustomer
        try {
            insertNewCustomer.setString(1, userName);
            insertNewCustomer.setString(2, password);
            insertNewCustomer.setString(3, email);
            insertNewCustomer.setString(4, ccNumber);

            // inserts the new record and returns the number of the lines that update
            result = insertNewCustomer.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

    }

    // close database connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
