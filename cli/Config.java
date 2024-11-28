package cli;

import java.util.Scanner;

public class Config {
    Scanner myObj = new Scanner(System.in);
    private DataBase dataBase1 = new DataBase();

    public Config(DataBase dataBase1) {
        this.dataBase1 = dataBase1;      //main eke hdpu eka succefuly aran thiynne
    }

    public void settingInput(){
        System.out.print("Enter the total number of tickets: ");
        dataBase1.setTotalTickets(myObj.nextInt());

        System.out.print("Enter the ticket release rate: ");
        dataBase1.setTicketReleaseDate(myObj.nextInt());

        System.out.print("Enter the customer retrieval rate: ");
        dataBase1.setCustomerRetrievalRate(myObj.nextInt());

        System.out.print("Enter the maximum ticket capacity: ");
        dataBase1.setMaxTicketCapacity(myObj.nextInt()); 
        
        System.out.println("Configuration saved.\n");

    }

    public void gettingInput(){
        System.out.println();
        System.out.println("Total number of tickets: " + dataBase1.getTotalTickets());
        System.out.println("Ticket release rate: " + dataBase1.getTicketReleaseDate());
        System.out.println("Customer retrieval rate: " + dataBase1.getCustomerRetrievalRate());
        System.out.println("Maximum ticket capacity: " + dataBase1.getMaxTicketCapacity());
    }

}