package cli;

import java.util.Scanner;

public class Customer implements Runnable {
    private TicketPool ticketPool;

    public Customer(DataBase dataBase1) {
        this.ticketPool = new TicketPool(dataBase1);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Buy Tickets");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ticketPool.removeTicket();
                    break;
                case 2:
                    System.out.println("Exiting Customer Menu.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
