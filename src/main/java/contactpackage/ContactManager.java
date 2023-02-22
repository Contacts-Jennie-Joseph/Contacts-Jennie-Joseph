package contactpackage;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactManager {
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




// Load all of the contacts by calling a method that returns a List of contactpackage.Contact objects.
// Call a method that shows the user the main menu and returns their choice of action.
// Using the user's choice from the previous step, call a method that performs that action (modifying the contents of the List of contactpackage.Contact objects if applicable).
// Keep calling the method from step two until the user chooses to exit.
// Once the user chooses to exit, re-write the contents of the contacts.txt file using the List of contactpackage.Contact objects.



    }
}
