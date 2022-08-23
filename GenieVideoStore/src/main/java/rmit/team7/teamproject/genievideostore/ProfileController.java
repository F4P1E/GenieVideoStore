package rmit.team7.teamproject.genievideostore;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ProfileController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField gender;
    @FXML
    private TextField contact;
    @FXML
    private TextField age;
    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(Storage.getName());
        age.setText(Storage.getAge());
        gender.setText(Storage.getGender());
        email.setText(Storage.getEmail());
        contact.setText(Storage.getContact());
        password.setText(Storage.getPassword());

        if (Storage.getEmail() != null)
        {
            name.setDisable(true);
            age.setDisable(true);
            gender.setDisable(true);
            email.setDisable(true);
            contact.setDisable(true);
            password.setDisable(true);
        }
    }
    @FXML
    private Button save;

    @FXML
    private Button edit;

    @FXML
    void editButton(ActionEvent event)
    {
        System.out.println("edit button");
        name.setDisable(false);
        age.setDisable(false);
        gender.setDisable(false);
        email.setDisable(false);
        contact.setDisable(false);
        password.setDisable(false);
    }

    @FXML
    void saveButton(ActionEvent event)
    {
        name.setDisable(true);
        age.setDisable(true);
        gender.setDisable(true);
        email.setDisable(true);
        contact.setDisable(true);
        password.setDisable(true);

        removeLine();
        addLine();
    }

    private void addLine(){
        String line = name.getText() + "," + email.getText() + "," + password.getText() + "," +age.getText() + "," +gender.getText()+ "," +contact.getText();

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("TexTFiles/database.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Add Line Failed!" +e);
        }

    }

    private void removeLine() {
        try
        {
            BufferedReader file = new BufferedReader(new FileReader("TextFiles/database.txt"));
            String line;
            String input = "";
            while ((line = file.readLine()) != null)
            {
                if (line.contains(Storage.getEmail()))
                {
                    line = "";
                    System.out.println("Line Deleted.");
                }
                input += line + '\n';
            }
            FileOutputStream File = new FileOutputStream("TextFiles/database.txt");
            File.write(input.getBytes());
            file.close();
            file.close();
        }
        catch (Exception e)
        {
            System.out.println("Problem Reading File.");
        }
    }


}





