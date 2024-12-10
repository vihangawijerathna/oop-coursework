package cli;

import java.util.Scanner;

public class Vendor implements Runnable {
    private DataBase dataBase;
    private TicketPool ticketPool;

    public Vendor(DataBase dataBase) {
        this.dataBase = dataBase;
        this.ticketPool = new TicketPool(dataBase);
    }

    @Override
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
                        ticketPool.addTickets();
                        break;
                    case 2:
                        System.out.println("Exiting Vendor Menu.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
