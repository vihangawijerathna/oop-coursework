package cli;

import java.util.Scanner;

public class Config {
    Scanner myObj = new Scanner(System.in);
    private DataBase dataBase;

    public Config(DataBase dataBase) {
        this.dataBase = dataBase; // Reference to the main DataBase instance
    }

    public void settingInput() {
        System.out.println("Please enter configuration values:");

        while (true) {
            try {
                System.out.print("Enter the total number of tickets (positive integer): ");
                int totalTickets = Integer.parseInt(myObj.nextLine());
                if (totalTickets <= 0) {
                    System.out.println("Error: Total tickets must be a positive integer.");
                    continue;
                }
                dataBase.setTotalTickets(totalTickets);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the ticket release rate (positive integer): ");
                int ticketReleaseRate = Integer.parseInt(myObj.nextLine());
                if (ticketReleaseRate <= 0) {
                    System.out.println("Error: Ticket release rate must be a positive integer.");
                    continue;
                }
                dataBase.setTicketReleaseRate(ticketReleaseRate);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the customer retrieval rate (positive integer): ");
                int customerRetrievalRate = Integer.parseInt(myObj.nextLine());
                if (customerRetrievalRate <= 0) {
                    System.out.println("Error: Customer retrieval rate must be a positive integer.");
                    continue;
                }
                dataBase.setCustomerRetrievalRate(customerRetrievalRate);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the maximum ticket capacity (less than or equal to total tickets): ");
                int maxTicketCapacity = Integer.parseInt(myObj.nextLine());
                if (maxTicketCapacity > dataBase.getTotalTickets()) {
                    System.out.println("Error: Maximum ticket capacity must be less than or equal to the total number of tickets.");
                    continue;
                }
                dataBase.setMaxTicketCapacity(maxTicketCapacity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        System.out.println("Configuration saved successfully.\n");
    }

    public void gettingInput() {
        System.out.println("\nCurrent Configuration:");
        System.out.println("Total number of tickets: " + dataBase.getTotalTickets());
        System.out.println("Ticket release rate: " + dataBase.getTicketReleaseRate());
        System.out.println("Customer retrieval rate: " + dataBase.getCustomerRetrievalRate());
        System.out.println("Maximum ticket capacity: " + dataBase.getMaxTicketCapacity());
    }
}
