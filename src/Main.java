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


//        for(int i = 0; i < parkLot.totalParkingSpots;i++){
//
//            if (parkLot.getParkSpots().get(i) == null) {
//                ParkingType type = ParkingType.NORMAL;
//                if (i % 10 == 0) {
//                    type = ParkingType.HANDICAP;
//                } else if (i % 5 == 0) {
//                    type = ParkingType.EV;
//                }
//
//                parkLot.getParkSpots().add(new ParkingSpot(i, true, type));
//            } else {
//                System.out.println("Spot " + i + " is occupied");
//            }
        //}

        spots = parkLot.getParkSpots();
        activeTickets.parkingMenu();
        System.out.println("\n ");
        System.out.println("Total available ParkingSpots: " + activeParking.getTotalAvailableParkingSpots());
    }
}