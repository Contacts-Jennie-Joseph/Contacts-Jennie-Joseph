package contactpackage;


import contactpackage.util.Input;

import java.util.Scanner;
import java.util.ArrayList;


public class ContactManager {
    private static Input input = new Input();

    public static Contact theContact = null;

    static ArrayList<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contact Mary = new Contact("Mary", "9123938970");
        Contact Joey = new Contact("Joey", "83725930180");
        Contact Roy = new Contact("Roy", "8737289302");
        System.out.println(Mary);
        System.out.println(Joey);
        System.out.println(Roy);
//        List<String> contactStrings = Arrays.asList(Mary.toFileString(), Joey.toFileString(), Roy.toFileString());

//        try{
//            Files.createDirectories(dirPath);
//            Files.createFile(filepath);
//            Files.write(filepath, contactStrings);
//        } catch(FileAlreadyExistsException e){
//            System.out.println("the file exists!");
//        } catch(IOException e){
//            System.out.println("File write exception: " + e.getMessage());
//            e.printStackTrace();
//        }

        contacts.add(Mary);
        contacts.add(Joey);
        contacts.add(Roy);
//        List<String> contactStrings = Arrays.asList(Mary.toFileString(), Joey.toFileString(), Roy.toFileString());
//        Path filepath = Paths.get("data", "contactStringsList.txt");
//        Path dirPath = Paths.get("data");
//        try{
//            Files.createDirectories(dirPath);
//            Files.createFile(filepath);
//            Files.write(filepath, contactStrings);
//        } catch(FileAlreadyExistsException e){
//            System.out.println("the file exists!");
//        } catch(IOException e){
//            System.out.println("File write exception: " + e.getMessage());
//            e.printStackTrace();
//        }

        mainMenu();
        System.out.println(contacts);

//        try {
//            List<String> allStrings = Files.readAllLines(filepath);
//            System.out.println(allStrings);
//
////            System.out.println(fileStrings.size());
////            System.out.println(fileStrings);
//        } catch (IOException e) {
//            System.out.println("file read exception: " + e.getMessage());
//        }

// Load all of the contacts by calling a method that returns a List of contactpackage.Contact objects.
// Call a method that shows the user the main menu and returns their choice of action.
// Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of contactpackage.Contact objects if applicable).
// Keep calling the method from step two until the user chooses to exit.
// Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of contactpackage.Contact objects.

    }

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

//        print out their contact list
//        System.out.println("Bye");
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

    private static ArrayList<Contact> deleteContact() {
        String searchedContact = input.getString("Enter contact to delete: ");
        for (Contact contact : contacts) {
            if (contact.getName().equals(searchedContact)) {

                System.out.println("You have deleted this contact.");
            }
        }
        return contacts;
    }

    private static void searchContacts() {
//        user input who's name do they want
//        if they choice this name then sout it out
//        for (Contact contact: contacts) {
//            if (choice.equals contacts)
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

    private static Contact createContact() {
        String name = input.getString("Enter your contact's name: ");
        String phoneNumber = input.getString("Enter your contact's phone number: ");
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println(contact);
        return contact;
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

