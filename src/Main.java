import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        ParkLot parkLot = new ParkLot(80,"Helsfyr parking",5);
        List<ParkingSpot> spots;
        ActiveParking activeParking = new ActiveParking(parkLot);
        Generate_Active_Tickets activeTickets = new Generate_Active_Tickets(activeParking);

        spots = parkLot.getParkSpots();
        activeTickets.parkingMenu();
        System.out.println("\n ");

    }
}