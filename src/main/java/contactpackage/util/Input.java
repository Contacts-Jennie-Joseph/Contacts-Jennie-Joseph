package contactpackage.util;

import java.util.Scanner;

public class Input {
    private Scanner sc;
// SCANNER CONSTRUCTOR
    public Input() {
        sc = new Scanner(System.in);
    }
// END CONSTRUCTOR

    public String getString(){
        return sc.nextLine();
    }
    public String getString(String prompt){
        System.out.println(prompt);
        return getString();
    }
    public boolean yesNo(){
        String response = getString();
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n")){
            return true;
        }
        return false;
    }
    public boolean yesNo(String prompt){
        System.out.println(prompt);
        return yesNo();
    }
    public int getInt(int min, int max, String userInput){
        System.out.println(userInput);
    return getInt(min, max);
    }
    public int getInt(int min, int max){
//        System.out.printf("Enter a number between $d and %d%n", min, max);
        int anInt = getInt();
        if (anInt < min || anInt > max){
            System.out.printf("That was not between %d and %d%n!!", min, max);
            return getInt(min, max);
        }
        return anInt;
    }
    public int getInt(){
        int userInt = 0;
        try {
            Integer.valueOf(userInt);
            System.out.println("Please enter an integer.");
        }catch (NumberFormatException userInput) {
            System.out.println("Exception triggered.");
        }
        return sc.nextInt();

    }
    public double getDouble() {
        double userDouble = 0;
        try{
            Double.valueOf(userDouble);
            System.out.println("Please enter a double.");
        } catch (NumberFormatException userInput){
            System.out.println("Exception triggered.");
        }
        return sc.nextDouble();
    }
    public int getBinary(){
        int userBinary = 0;
        try{

            userBinary = Integer.valueOf(userBinary);
        } catch (NumberFormatException userInput){
            System.out.println("Exception triggered.");
        }
        return getBinary();
    }
    public int getHex(){
        int userHex = 0;
        String s = getString();
        try {
            userHex = Integer.valueOf(userHex);
        } catch (NumberFormatException userInput){
            System.out.println("Exception triggered.");
        }
        return getHex();
    }
        public double getDouble(double min, double max){
        System.out.printf("Enter a number between $f and %f%n", min, max);
        double aDouble = getDouble();
        if (aDouble < min || aDouble > max){
            System.out.printf("That was not between %f and %f%n!!", min, max);
            return getDouble(min, max);
        }
        return aDouble;
    }

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public static void main(String[] args) {
        Input myInput = new Input();



        System.out.println(myInput.getString());

        int x = myInput.getInt(5, 10);
        System.out.println(x);

        double y = myInput.getDouble(5, 10);
        System.out.println(y);

        myInput.getString();

        myInput.yesNo("Continue Y/N? ");
        System.out.print("Sike!!");
    }

    public Integer getInt(String prompt) {
        System.out.println(prompt);
        return null;
    }
} // END CLASS