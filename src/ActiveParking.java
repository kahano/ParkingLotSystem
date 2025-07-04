import java.util.Optional;

public class ActiveParking {


    private ParkLot parklot;
    private int maxHours = 4;


    public ActiveParking(ParkLot lot, int maxHours){

        this.parklot = lot;
        this.maxHours = maxHours;
    }


    public void setParkLot(ParkLot lot){
        parklot = lot;
    }

    public ParkLot getParklot() {
        return parklot;
    }

    public int getMaxHours(){
        return this.maxHours;
    }


    public boolean parkVehicle(Vehicle vehicle, int spotNumber){

        Optional<ParkingSpot> spotOpt = getParkingSpotBySpotNumber(spotNumber);
        if (spotOpt.isPresent()) {
            ParkingSpot spot = spotOpt.get();
            if (spot.isParkAvailable()) {
                spot.setParkUnAvailable(vehicle);
                return true;
            }
        }
        return false;
    }

    public Vehicle unParkVehicle(String registrationNumber){
        for(ParkingSpot parkingSpot: parklot.getParkSpots()){

            if(!parkingSpot.isParkAvailable() && parkingSpot.getVehicle().getRegistrationNumber().equals(registrationNumber)){
                Vehicle parkedVehicle = parkingSpot.getVehicle();
                parkingSpot.exitVehicle();
                return parkedVehicle;
            }
        }
        throw new IllegalStateException("Vehicle is not found ");
    }

    private Optional<ParkingSpot> getParkingSpotBySpotNumber(int spotNumber){

        return parklot.getParkSpots().stream().filter(spot -> spot.getSpotNumber() == spotNumber).findFirst();
    }

    public long getTotalAvailableParkingSpots(){
        return parklot.getParkSpots().stream().filter(ParkingSpot::isParkAvailable).count();
    }
}
