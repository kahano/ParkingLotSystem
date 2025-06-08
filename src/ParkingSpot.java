import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingSpot {

    private  int spotNumber;
    private Vehicle vehicle;
    private boolean parkIsAvailable = false;
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




    public boolean isParkIsAvailable() {
        return parkIsAvailable = vehicle == null;
    }

    public void setParkUnAvailable(Vehicle parkedVehicle) {
        vehicle = parkedVehicle;
    }

    public void ExitVehicle(){
        vehicle = null;
    }



}
