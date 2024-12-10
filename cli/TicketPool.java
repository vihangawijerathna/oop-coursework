package cli;

import java.util.Scanner;

public class TicketPool {

    private DataBase dataBase;
    private int currentTickets = 0;

    public TicketPool(DataBase dataBase) {
        this.dataBase = dataBase;
        this.currentTickets = dataBase.getTotalTickets();
    }

    public synchronized void addTickets() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tickets to add: ");

        try {
            int ticketsToAdd = Integer.parseInt(scanner.nextLine());

            if (ticketsToAdd <= 0) {
                System.out.println("Please enter a positive number of tickets.");
                return;
            }

            if (ticketsToAdd > dataBase.getTicketReleaseRate()) {
                System.out.println("Cannot add more than the ticket release rate of " + 
                                   dataBase.getTicketReleaseRate() + " tickets.");
                return;
            }

            int currentTickets = dataBase.getTotalTickets();
            int maxTicketCapacity = dataBase.getMaxTicketCapacity();

            if (currentTickets + ticketsToAdd > maxTicketCapacity) {
                System.out.println("Cannot add that many tickets. Maximum capacity is: " + maxTicketCapacity);
                return;
            }

            // Update tickets
            currentTickets += ticketsToAdd;
            dataBase.setTotalTickets(currentTickets);
            System.out.println("Vendor added " + ticketsToAdd + " tickets. Current tickets: " + currentTickets);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    public synchronized void removeTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many tickets do you want to buy: ");

        try {
            int ticketsToBuy = Integer.parseInt(scanner.nextLine());

            if (ticketsToBuy <= 0) {
                System.out.println("Please enter a positive number of tickets.");
                return;
            }

            int availableTickets = dataBase.getTotalTickets();
            int maxBuyLimit = dataBase.getCustomerRetrievalRate();

            if (ticketsToBuy > maxBuyLimit) {
                System.out.println("You can buy a maximum of " + maxBuyLimit + " tickets at a time.");
                return;
            }

            if (ticketsToBuy > availableTickets) {
                System.out.println("Only " + availableTickets + " tickets are available.");
                return;
            }

            // Update tickets
            int remainingTickets = availableTickets - ticketsToBuy;
            dataBase.setTotalTickets(remainingTickets);
            System.out.println("Buying " + ticketsToBuy + " tickets...");
            System.out.println("Available tickets: " + remainingTickets);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
