package cli;

import java.util.Scanner;

public class Vendor {
    private DataBase dataBase1; // Reference to shared DataBase instance
    private TicketPool ticketPool; // TicketPool object to manage tickets

    // Constructor to accept DataBase instance
    public Vendor(DataBase dataBase1) {
        this.dataBase1 = dataBase1;
        this.ticketPool = new TicketPool(dataBase1); // Initialize TicketPool with the shared DataBase instance
    }

    // Main method for the Vendor menu
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nVendor Menu:");
            System.out.println("1. Add Tickets");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ticketPool.addTickets(); // Call the addTickets method
                        break;
                    case 2:
                        System.out.println("Exiting Vendor Menu.");
                        isRunning = false; // Exit the menu loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close(); // Close the scanner
    }
}
