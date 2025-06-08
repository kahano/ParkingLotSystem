import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingSpot {

    private  int spotNumber;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;


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


    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
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
