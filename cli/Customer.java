package cli;

import java.util.Scanner;

public class Customer {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Display menu
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Tickets");
            System.out.println("2. Purchase Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter the number of the action you want to perform (1, 2, or 3): ");

            int customerType;
            try {
                customerType = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Handle menu options
                switch (customerType) {
                    case 1:
                        viewTickets();
                        break;
                    case 2:
                        purchaseTicket();
                        break;
                    case 3:
                        System.out.println("Exiting Customer Menu. Goodbye!");
                        isRunning = false; // Exit the loop
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close(); // Close the scanner
    }

    // Placeholder methods for functionality
    private void viewTickets() {
        System.out.println("Viewing tickets...");
        // Add logic for viewing tickets
    }

    private void purchaseTicket() {
        System.out.println("Purchasing a ticket...");
        // Add logic for purchasing a ticket
    }
}
