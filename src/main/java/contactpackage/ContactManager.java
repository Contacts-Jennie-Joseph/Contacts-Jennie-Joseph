package contactpackage;

import contactpackage.util.Input;

public class ContactManager {
    private static Input input = new Input();

    public static Contact theContact = null;
    public static void main(String[] args) {
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
            MenuChoice choice = MenuChoice.fromInt(input.getInt(0, 5, "Enter your choice: "));
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
            case SearchContacts -> searchContacts();
            case ViewContacts -> viewContacts();
            case CreateContact -> theContact = (Contact) createContact();
            case DeleteContact -> deleteContact();
        }
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
        String phoneNumber = input.getString("Enter your contact's phone number: ");
        Contact contact = new Contact(name, phoneNumber);
        return contact;
    }

    private static void printMenu() {
    }

    private static void printWelcome() {
        System.out.println("Welcome to your Contacts Manager");
    }
}

