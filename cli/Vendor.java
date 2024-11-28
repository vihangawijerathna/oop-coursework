package cli;

import java.util.Scanner;

public class Vendor {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Display menu
            System.out.println("\nVendor Menu:");
            System.out.println("1. Manage Tickets");
            System.out.println("2. View Sales");
            System.out.println("3. Exit");
            System.out.print("Enter the number of the action you want to perform (1, 2, or 3): ");

            int vendorType;
            try {
                vendorType = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                // Handle menu options
                switch (vendorType) {
                    case 1:
                        manageTickets();
                        break;
                    case 2:
                        viewSales();
                        break;
                    case 3:
                        System.out.println("Exiting Vendor Menu. Goodbye!");
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
    private void manageTickets() {
        System.out.println("Managing tickets...");
        // Add logic for managing tickets
    }

    private void viewSales() {
        System.out.println("Viewing sales...");
        // Add logic for viewing sales
    }
}
