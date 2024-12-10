package cli;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    private DataBase dataBase;

    public Demo(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void runDemo() {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(10); // 5 customers + 5 vendors
    
        // Create instances of Customer and Vendor
        for (int i = 0; i < 5; i++) {
            executor.execute(new Customer(dataBase)); // 5 customer threads
            executor.execute(new Vendor(dataBase));   // 5 vendor threads
        }
    
        // Allow the user to log in as either customer or vendor
        while (true) {
            System.out.println("\nChoose login type:");
            System.out.println("1. Customer");
            System.out.println("2. Vendor");
            System.out.println("3. Exit");
    
            int choice = scanner.nextInt();
            if (choice == 1) {
                // Log in as a customer, create a new instance
                executor.execute(new Customer(dataBase));
            } else if (choice == 2) {
                // Log in as a vendor, create a new instance
                executor.execute(new Vendor(dataBase));
            } else if (choice == 3) {
                System.out.println("Exiting Demo.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    
        executor.shutdown(); // Shutdown executor after demo ends
    }
}
