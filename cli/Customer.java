package cli;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Runnable {
    private static final AtomicInteger customerCounter = new AtomicInteger(0);
    private int customerId;
    private DataBase dataBase;
    private TicketPool ticketPool;

    public Customer(DataBase dataBase) {
        this.customerId = customerCounter.incrementAndGet();
        this.dataBase = dataBase;
        this.ticketPool = new TicketPool(dataBase);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nCustomer " + customerId + " Menu:");
            System.out.println("1. Buy Tickets");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ticketPool.removeTicket();
                        break;
                    case 2:
                        System.out.println("Customer " + customerId + " exiting.");
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
}// package cli;

// import java.util.Scanner;

// public class Customer implements Runnable {
//     private DataBase dataBase;
//     private TicketPool ticketPool;

//     public Customer(DataBase dataBase) {
//         this.dataBase = dataBase;
//         this.ticketPool = new TicketPool(dataBase);
//     }

//     @Override
//     public void run() {
//         Scanner scanner = new Scanner(System.in);
//         boolean isRunning = true;

//         while (isRunning) {
//             System.out.println("\nCustomer Menu:");
//             System.out.println("1. Buy Tickets");
//             System.out.println("2. Exit");
//             System.out.print("Enter your choice: ");

//             int choice = scanner.nextInt();
//             switch (choice) {
//                 case 1:
//                     ticketPool.removeTicket();
//                     break;
//                 case 2:
//                     System.out.println("Exiting Customer Menu.");
//                     isRunning = false;
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }
// }
