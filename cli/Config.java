package cli;

import java.util.Scanner;

public class Config {
    Scanner myObj = new Scanner(System.in);
    private DataBase dataBase1;

    public Config(DataBase dataBase1) {
        this.dataBase1 = dataBase1; // Reference to the main DataBase instance
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
                dataBase1.setTotalTickets(totalTickets);
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
                dataBase1.setTicketReleaseRate(ticketReleaseRate);
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
                dataBase1.setCustomerRetrievalRate(customerRetrievalRate);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the maximum ticket capacity (less than or equal to total tickets): ");
                int maxTicketCapacity = Integer.parseInt(myObj.nextLine());
                if (maxTicketCapacity > dataBase1.getTotalTickets()) {
                    System.out.println("Error: Maximum ticket capacity must be less than or equal to the total number of tickets.");
                    continue;
                }
                dataBase1.setMaxTicketCapacity(maxTicketCapacity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }

        System.out.println("Configuration saved successfully.\n");
    }

    public void gettingInput() {
        System.out.println("\nCurrent Configuration:");
        System.out.println("Total number of tickets: " + dataBase1.getTotalTickets());
        System.out.println("Ticket release rate: " + dataBase1.getTicketReleaseRate());
        System.out.println("Customer retrieval rate: " + dataBase1.getCustomerRetrievalRate());
        System.out.println("Maximum ticket capacity: " + dataBase1.getMaxTicketCapacity());
    }
}
