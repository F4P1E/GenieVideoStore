package rmit.team7.teamproject.genievideostore;

import javafx.scene.shape.StrokeLineCap;

public class Storage {
    private static String Name;
    private static String Age;
    private static String Gender;
    private static String Email;
    private static String Contact;
    private static String password;

    //Function getName and return name
    public static String getName() {
        return Name;
    }
    //Function setName
    public static void setName(String name) {
        Name = name;
    }
    //Function getAge and return age
    public static String getAge() {
        return Age;
    }
    //Function setAge
    public static void setAge(String age) {
        Age = age;
    }
    //Function getGender and return gender
    public static String getGender() {
        return Gender;
    }
    //Function setGender
    public static void setGender(String gender) {
        Gender = gender;
    }
    //Function getEmail and return email
    public static String getEmail(){
        return Email;
    }
    //Function setEmail
    public static void setEmail(String email){
        Email = email;
    }
    //Function getContact and return contact
    public static String getContact(){
        return Contact;
    }
    //Function setContact
    public static void setContact(String contact) {
        Contact = contact;
    }
    //Function getPassword and return password
    public static String getPassword() {
        return password;
    }
    //Function setPassword
    public static void setPassword(String password) {
        Storage.password = password;
    }
}
