import java.util.Optional;

public class ActiveParking {


    private ParkLot parklot;
    private static final int maxHours = 4;

    public ActiveParking(ParkLot lot){
        this.parklot = lot;
    }


    public void setParkLot(ParkLot lot){
        parklot = lot;
    }

    public ParkLot getParklot() {
        return parklot;
    }


    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot parkSpot : parklot.getParkSpots()){
            if(parkSpot.isParkIsAvailable()){
                parkSpot.setParkUnAvailable(vehicle);
                return true;
            }
        }
        return false;
    }

    public Vehicle unParkVehicle(String registrationNumber){
        for(ParkingSpot parkingSpot: parklot.getParkSpots()){

            if(!parkingSpot.isParkIsAvailable() && parkingSpot.getVehicle().getRegistrationNumber().equals(registrationNumber)){
                Vehicle parkedVehicle = parkingSpot.getVehicle();
                parkingSpot.ExitVehicle();
                return parkedVehicle;
            }
        }
        throw new IllegalStateException("Vehicle is not found ");
    }

    Optional<ParkingSpot> getParkingSpotBySpotNumber(int spotNumber){

        return parklot.getParkSpots().stream().filter(spot -> spot.getSpotNumber() == spotNumber).findFirst();
    }

    public long getAvailableParkingSpots(){
        return parklot.getParkSpots().stream().filter(ParkingSpot::isParkIsAvailable).count();
    }
}
