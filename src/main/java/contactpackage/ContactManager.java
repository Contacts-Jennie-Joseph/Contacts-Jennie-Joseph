package contactpackage;


import contactpackage.util.Input;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactManager {
    private static Input input = new Input();

    public static Contact theContact = null;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contact Mary = new Contact("Mary", 912393890);
        Contact Joey = new Contact("Joey", 837293018);
        Contact Roy = new Contact("Roy", 873728932);
        System.out.println(Mary);
        System.out.println(Joey);
        System.out.println(Roy);
        List<String> contactStrings = Arrays.asList(Mary.toFileString(), Joey.toFileString(), Roy.toFileString());
        Path filepath = Paths.get("data", "contactStringsList.txt");
        Path dirPath = Paths.get("data");
        try{
            Files.createDirectories(dirPath);
            Files.createFile(filepath);
            Files.write(filepath, contactStrings);
        } catch(FileAlreadyExistsException e){
            System.out.println("the file exists!");
        } catch(IOException e){
            System.out.println("File write exception: " + e.getMessage());
            e.printStackTrace();
        }
        mainMenu();

// Load all of the contacts by calling a method that returns a List of contactpackage.Contact objects.
// Call a method that shows the user the main menu and returns their choice of action.
// Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of contactpackage.Contact objects if applicable).
// Keep calling the method from step two until the user chooses to exit.
// Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of contactpackage.Contact objects.

    }

    private static void mainMenu() {
        printWelcome();
        while(true) {
            // print menu
            printMenu();
            MenuChoice choice = MenuChoice.fromInt(input.getInt(1, 5, "Enter your choice: "));
            // process user's choice
            doChoice(choice);
            // if user quits then break
            if(MenuChoice.Exit.equals(choice)) {
                break;
            }
        }
        System.out.println("Bye");
    }

    private static void doChoice(MenuChoice choice) {
        switch (choice) {
            case ViewContacts -> viewContacts();
            case CreateContact -> theContact = (Contact) createContact();
            case SearchContacts -> searchContacts();
            case DeleteContact -> deleteContact();
            case Exit -> exitContact();
        }
    }

    private static void exitContact() {
    }

    private static void deleteContact() {
    }

    private static void searchContacts() {
    }

    private static void viewContacts() {
        System.out.println(theContact);
    }

    private static Object createContact() {
        String name = input.getString("Enter your contact's name: ");
        int phoneNumber = input.getInt("Enter your contact's phone number: ");
        Contact contact = new Contact(name, phoneNumber);
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

