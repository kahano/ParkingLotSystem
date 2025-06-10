import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        ParkLot parkLot = new ParkLot(80,"Helsfyr parking",5);
        ActiveParking activeParking = new ActiveParking(parkLot);
        Generate_Active_Tickets activeTickets = new Generate_Active_Tickets(activeParking);
        activeTickets.parkingMenu();
        System.out.println("\n ");

    }
}