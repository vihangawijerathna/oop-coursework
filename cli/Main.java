package cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create an instance of DataBase
        DataBase dataBase1 = new DataBase();
        
        
        // Create an instance of Config
        Config config1 = new Config(dataBase1);

        // Call the settingInput method
        config1.settingInput();

        // Call the gettingInput method
        //config1.gettingInput();

         // Display a welcome message
        System.out.println("******************************");
        System.out.println("** Welcome to the Ticket App **"); 
        System.out.println("******************************");

        // Prompt for user type
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you a Vendor (V) or a Customer (C)? ");
        String userType = scanner.nextLine().toUpperCase(); 

        // Basic input validation and next steps
        if (userType.equals("V")) {
            Vendor vendor = new Vendor(dataBase1);
            vendor.run(); 
        } else if (userType.equals("C")) {
            Customer customer = new Customer(dataBase1);
            TicketPool ticketPool = new TicketPool(dataBase1);
            customer.run();
        } else {
            System.out.println("Invalid input. Please enter V or C.");
        }

        scanner.close();
    }
}