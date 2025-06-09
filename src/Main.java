import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkLot parkLot = new ParkLot(80,"Helsfyr parking",25);
        List<ParkingSpot> spots;
        ActiveParking activeParking = new ActiveParking(parkLot);
        Generate_Active_Tickets activeTickets = new Generate_Active_Tickets(activeParking);

        spots = parkLot.getParkSpots();
        activeTickets.parkingMenu();
        System.out.println("\n ");
        System.out.println("Total available ParkingSpots: " + activeParking.getTotalAvailableParkingSpots());
    }
}