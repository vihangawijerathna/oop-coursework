package cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of DataBase
        DataBase dataBase = new DataBase();
    
        // Create an instance of Config
        Config config = new Config(dataBase);
    
        // Call the settingInput method
        config.settingInput();
    
        // Display a welcome message
        System.out.println("******************************");
        System.out.println("** Welcome to the Ticket App **");
        System.out.println("******************************");
    
        // Prompt for user type
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Are you a Vendor (V), Customer (C), or Exit (E)? else to see the demo (D) ");
            String userType = scanner.nextLine().toUpperCase();
    
            // Basic input validation and next steps
            switch (userType) {
                case "V":
                    Vendor vendor = new Vendor(dataBase);
                    vendor.run();
                    break;
                case "C":
                    Customer customer = new Customer(dataBase);
                    customer.run();
                    break;
                case "D":
                    Demo demo = new Demo(dataBase);
                    demo.runDemo();
                    break;
                case "E":
                    System.out.println("Exiting the Ticket App. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Please enter V, C, or E.");
            }
        }
    }
}