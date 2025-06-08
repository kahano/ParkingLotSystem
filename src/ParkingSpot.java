import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingSpot {

    private  int spotNumber;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private BigDecimal totalIncome;
    private Vehicle vehicle;
    private boolean parkIsAvailable = false;
    final ParkingType parkingType;

    public ParkingSpot(int spotNumber, BigDecimal totalIncome, boolean parkIsAvailable){
        this(spotNumber,totalIncome,parkIsAvailable,ParkingType.NORMAL);
    }

    public ParkingSpot(int spotNumber,BigDecimal totalIncome, boolean parkStatus, ParkingType type ) {
        this.spotNumber = spotNumber;
        this.totalIncome = totalIncome;
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

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public boolean isParkIsAvailable() {
        return parkIsAvailable = vehicle == null;
    }

    public void setParkUnAvailable(Vehicle parkedVehicle) {
        vehicle = parkedVehicle;
    }



}
