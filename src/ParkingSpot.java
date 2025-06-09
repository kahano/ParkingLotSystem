import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingSpot {

    private  int spotNumber;
    private Vehicle vehicle;
    private boolean parkIsAvailable = true;
    private ParkingType parkingType;


    public ParkingSpot(int spotNumber){
        this(spotNumber,true, ParkingType.NORMAL);
    }

    public ParkingSpot(int spotNumber, boolean parkStatus, ParkingType type ) {
        this.spotNumber = spotNumber;
        this.parkIsAvailable  = parkStatus;
        this.parkingType = type;
    }

    public String getParkingType(){
        return parkingType.name().toLowerCase();
    }

    public void setParkingType(ParkingType type){
        parkingType = type;
    }


    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }




    public boolean isParkAvailable() {
        return vehicle == null;
    }


    public void setParkUnAvailable(Vehicle parkedVehicle) {

        if (parkedVehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (!isParkAvailable()) {
            throw new IllegalStateException("Spot is already occupied");
        }
        this.vehicle = parkedVehicle;
    }

    public void exitVehicle(){
        this.vehicle = null;
    }



}
