package rmit.team7.teamproject.genievideostore.managers;

import rmit.team7.teamproject.genievideostore.controller.AddEmployeePageController;
import rmit.team7.teamproject.genievideostore.controller.AddProductPageController;
import rmit.team7.teamproject.genievideostore.controller.AdministratorMainPageController;
import rmit.team7.teamproject.genievideostore.controller.EmployeeMainPageController;
import rmit.team7.teamproject.genievideostore.controller.LoginPageController;
import rmit.team7.teamproject.genievideostore.controller.SignUpController;
import rmit.team7.teamproject.genievideostore.controller.UserMainPageController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewController {
    /* CONSTANST */

    /**
     * Represents the main page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String START_PAGE = "startPage";
    /**
     * Represents the sign-up page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String SIGN_UP_PAGE = "signUpPage";
    /**
     * Represents the user main page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String USER_MAIN_PAGE = "userMainPage";
    /**
     * Represents the employee main page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String EMPLOYEE_MAIN_PAGE = "employeeMainPage";
    /**
     * Represents the administrator main page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String ADMINISTRATOR_MAIN_PAGE = "administratorMainPage";
    /**
     * Represents the add product page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String ADD_PRODUCT_PAGE = "addProductPage";
    /**
     * Represents the add employee page string. Used to start being passed to the method {@link #showLayout(String)} to be displayed.
     **/
    public static final String ADD_EMPLOYEE_PAGE = "addEmployeePage";
    /* /* LAYOUT ROOT ELEMENTS */
    private Stage stage;

    /*
     * The instance is static so it is shared among all instances of the class. It is also private
     * so it is accessible only within the class.
     */
    private static ViewController instance = null;

    /*
     * The constructor is private so it is accessible only within the class.
     */
    private ViewController() {

    }

    /**
     * The constructor is called only if the static instance is null, so only the first time
     * that the getInstance() method is invoked.
     * All the other times the same instance object is returned.
     * @return the instance object is returned.
     **/
    public static ViewController getInstance() {
        if (instance == null)
            instance = new ViewController();
        return instance;
    }

    /**
     * show the root layout.
     *
     * @param page is the string of the page you want to view.
     */
    public void showLayout(String page) {
        try {
            switch(page) {
                case START_PAGE:
                    LoginPageController.show();
                    return;
                case SIGN_UP_PAGE:
                    SignUpController.show();
                    return;
                case USER_MAIN_PAGE:
                    UserMainPageController.show();
                    return;
                case EMPLOYEE_MAIN_PAGE:
                    EmployeeMainPageController.show();
                    return;
                case ADMINISTRATOR_MAIN_PAGE:
                    AdministratorMainPageController.show();
                    return;
                case ADD_PRODUCT_PAGE:
                    AddProductPageController.show();;
                    return;
                case ADD_EMPLOYEE_PAGE:
                    AddEmployeePageController.show();
                    return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAndStart(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle("e-commerce");
        this.stage.setMinHeight(540);
        this.stage.setMinWidth(515);

        showLayout(START_PAGE);
    }

    public void setScene(Scene scene) {
        this.stage.setScene(scene);
        this.stage.show();
    }

}
