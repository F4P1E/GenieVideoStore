package rmit.team7.teamproject.genievideostore;

import javafx.scene.shape.StrokeLineCap;

public class Storage {
    private static String Name;
    private static String Age;
    private static String Gender;
    private static String Email;
    private static String Contact;
    private static String password;

    public static String getName() {
        return Name;
    }
    public static void setName(String name) {
        Name = name;
    }
    public static String getAge() {
        return Age;
    }
    public static void setAge(String age) {
        Age = age;
    }
    public static String getGender() {
        return Gender;
    }
    public static void setGender(String gender) {
        Gender = gender;
    }
    public static String getEmail(){
        return Email;
    }
    public static void setEmail(String email){
        Email = email;
    }
    public static String getContact(){
        return Contact;
    }
    public static void setContact(String contact) {
        Contact = contact;
    }
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Storage.password = password;
    }
}