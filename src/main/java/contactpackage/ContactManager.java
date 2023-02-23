package contactpackage;


import contactpackage.util.Input;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;


public class ContactManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static Input input = new Input();

    public static Contact theContact = null;

    static ArrayList<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        Input input = new Input();
        Contact Mary = new Contact("Mary", "9123938970");
        Contact Joey = new Contact("Joey", "83725930180");
        Contact Roy = new Contact("Roy", "8737289302");
        System.out.println(Mary);
        System.out.println(Joey);
        System.out.println(Roy);
        contacts.add(Mary);
        contacts.add(Joey);
        contacts.add(Roy);

//        contacts = fetchContacts();
        mainMenu();
        System.out.println(contacts);

        writeContractsToFile(contacts);
    }
    private static void writeContractsToFile(ArrayList<Contact> contracts){
        Path dirPath = Paths.get("data");
        Path filepath = Paths.get("data", "contactStringsList.txt");
        try{
            Files.createDirectories(dirPath);
            Files.createFile(filepath);
        } catch(FileAlreadyExistsException e){
            System.out.println("the file exists!");
        } catch(IOException e){
            System.out.println("File write exception: " + e.getMessage());
            e.printStackTrace();
        }

        ArrayList<String> contactStrings = new ArrayList<>();
//        ArrayList<string> fileStrings = new ArrayList<>();
//        1. for each fighter,
//                  add that's string version to a list of strings
        for (Contact contact : contacts) {
            String wholeContact = contact.toFileString();
            contactStrings.add(wholeContact);
        }
//        2. get the path object for the file
//        3.write whole list of strings to the file
        try{
            Files.write(filepath, contactStrings);
        }catch (IOException e){
            System.out.println("File write exception: " + e.getMessage());
        }

        try {
            List<String> allStrings = Files.readAllLines(filepath);
            System.out.println(ANSI_PURPLE + allStrings + ANSI_RESET);
        } catch (IOException e) {
            System.out.println("file read exception: " + e.getMessage());
        }

    }

    //        for (string filestring: filestrings) {
//            fighter aFighter = fighter.fromFileString(filestring);
//        }
//        add it to an array list and then return that list

//    private static ArrayList<Contact> fetchContacts() {
//        // 1. make an empty contact array list
//        ArrayList<Contact> contactsArray = new ArrayList<>();
////        make a path object to the context file
//
////        get the strings from the contact file
////        for each string make a contact object
////              add that contact object to the array list
////        return the array list
//    }

    private static void mainMenu() {
        printWelcome();
        boolean done = true;
        while(done) {
            // print menu
            printMenu();
//            MenuChoice choice = MenuChoice.fromInt(input.getInt(1, 5, "Enter your choice: "));
            // process user's choice
            int choice = input.getInt(1, 5, "Enter your choice: ");
            doChoice(choice);
//            doChoice(choice);
            // if user quits then break
            if(choice == 5) {
                done = false;
            }
        }
    }

    private static void doChoice(int choice) {
        switch (choice) {
//            ViewContacts
            case 1 -> viewContacts();
//            CreateContact
            case 2 -> createContact();
//            SearchContacts
            case 3 -> searchContacts();
//            DeleteContact
            case 4 -> deleteContact();
//            Exit
        }
    }
    private static void deleteContact() {
        String searchedContact = input.getString("Enter contact to delete: ");
        Contact foundYou = null;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(searchedContact)) {
                foundYou = contacts.get(i);
            }
        }
        if (foundYou != null) {
            contacts.remove(foundYou);
            System.out.println("You have deleted this contact.");
        }
    }
    private static void searchContacts() {
        System.out.println(contacts.toString());
        String searchedContact = input.getString("Enter contact to search for: ");
        for (Contact contact : contacts) {
            if (contact.getName().equals(searchedContact)) {
                System.out.println(contact);
            }
        }
    }
    private static void viewContacts() {
        System.out.println(contacts.toString());
    }

    private static void createContact() {
        String name = input.getString("Enter your contact's name: ");
        String phoneNumber = input.getString("Enter your contact's phone number: ");
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name) || contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("That contact information already exists");
                System.out.println("hey you got here");
                createContact();
                return;
            }
        }
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("You have added " + contact);

    }

    private static void printMenu() {
        System.out.println("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):""");
    }

    private static void printWelcome() {
        System.out.println("Welcome to your Contacts Manager");
    }
}

