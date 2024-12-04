package cli;

import java.util.Scanner;

public class TicketPool {

    private DataBase dataBase1;
    private int currentTickets = 0;

    public TicketPool(DataBase dataBase1) {
        this.dataBase1 = dataBase1;
        this.currentTickets = dataBase1.getTotalTickets();
    }
    
    public void addTickets() {
        while(currentTickets < dataBase1.getMaxTicketCapacity()) {
            currentTickets = currentTickets + dataBase1.getTicketReleaseRate();
            if(currentTickets > dataBase1.getMaxTicketCapacity()) {
                currentTickets = dataBase1.getMaxTicketCapacity();
            }
            dataBase1.setTotalTickets(currentTickets);
            System.out.println("Vendor added tickets: " + currentTickets);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ticket pool is full.No more tickets can be added.");

    }


    public void removeTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Tickets do you want to buy: ");
        int ticketsToBuy = scanner.nextInt();

        int availableTickets = dataBase1.getTotalTickets();
        int maxBuyLimit = dataBase1.getCustomerRetrievalRate();

        if(ticketsToBuy > maxBuyLimit) {
            System.out.println("You can buy a maximum of " + maxBuyLimit + " tickets at a time.");
        } else if(ticketsToBuy > availableTickets) {
            System.out.println("Only " + availableTickets + " tickets are available.");
        } else {
            dataBase1.setTotalTickets(dataBase1.getTotalTickets() - ticketsToBuy);
            System.out.println("Buying " + ticketsToBuy + " tickets...");
            System.out.println("Available tickets: " + dataBase1.getTotalTickets());
        }
    }
}
