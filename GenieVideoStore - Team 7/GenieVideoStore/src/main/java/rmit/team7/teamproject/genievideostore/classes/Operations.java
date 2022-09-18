package rmit.team7.teamproject.genievideostore.classes;

import java.util.Scanner;
import rmit.team7.teamproject.genievideostore.managers.CredentialsManager;

public class Operations {
    /**
     *  Represents the key to the search operation.
     **/
    public static final String SEARCH = "search";
    /**
     *  Represents the key to the purchase operation.
     **/
    public static final String BUY = "buy";
    /**
     *  Represents the key to the shipping operation.
     **/
    public static final String SHIP_TO_CUSTOMER = "ship";
    /**
     *  Represents the key to the product update operation.
     **/
    public static final String UPDATE_PRODUCT = "update";
    /**
     *  Represents the key to creating a new employee.
     **/
    public static final String NEW_EMPLOYEE = "new";
    /**
     *  Represents the key to creating a new product.
     **/
    public static final String NEW_PRODUCT = "newp";
    /**
     *  Represents the key to the product removal operation.
     **/
    public static final String REMOVE_PRODUCT = "removep";
    /**
     *  Represents the key to the product printing operation.
     **/
    public static final String PRINT_PRODUCT = "p";
    /**
     *  Represents the key to the employee printing operation.
     **/
    public static final String PRINT_EMPLOYEE = "e";
    /**
     *  Represents the key to the disconnect operation.
     **/
    public static final String LOGOUT = "o";

    public static void printOperationThatUserCanDo(int typeOfPersonLoggedIn) {
        System.out.println("######## TYPE OF OPERATIONS YOU CAN DO ########");

        System.out.println("Print products list : (key : p)");

        switch(typeOfPersonLoggedIn){
            case CredentialsManager.USER:
                System.out.println("Search product : (key : search)");
                System.out.println("Buy one product (key : buy)");
                break;
            case CredentialsManager.EMPLOYEE:
                System.out.println("Ship a product : (key : ship)");
                System.out.println("Update quantity of a product : (key : update)");
                break;
            case CredentialsManager.ADMINISTRATOR:
                System.out.println("Print all employee : (key : e)");
                System.out.println("Add new employee : (key : new)");
                System.out.println("Add new product : (key : newp)");
                System.out.println("Remove a product : (key : removep)");
                break;
            default:
                System.out.println("Oops something went wrong with type of permissions...");
        }

        System.out.println("Logout : (key : o)");

        System.out.println("####################");

    }


    public static String askUserOperation() {

        System.out.println("Insert key of operation you want to do...");

        return scanAllPossibleRequest();
    }


    private static String scanAllPossibleRequest() {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();

        switch(key) {
            case SEARCH:
                return SEARCH;
            case BUY:
                return BUY;
            case SHIP_TO_CUSTOMER:
                return SHIP_TO_CUSTOMER;
            case UPDATE_PRODUCT:
                return UPDATE_PRODUCT;
            case NEW_EMPLOYEE:
                return NEW_EMPLOYEE;
            case NEW_PRODUCT:
                return NEW_PRODUCT;
            case REMOVE_PRODUCT:
                return REMOVE_PRODUCT;
            case PRINT_EMPLOYEE:
                return PRINT_EMPLOYEE;
            case PRINT_PRODUCT:
                return PRINT_PRODUCT;
            case LOGOUT:
                return LOGOUT;
            default:
                return null;
        }
    }
}
