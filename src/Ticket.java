import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private final LocalDateTime checkIn;
    private LocalDateTime checkOut;



    private Double price;

    private final Vehicle vehicle;

    public Ticket(Vehicle vehicle){
        this.vehicle = vehicle;
        checkIn = LocalDateTime.now();
    }

    public void setCheckOut(){
        checkOut = LocalDateTime.now();
    }

    public void calculateParkingPrice(Double pricePerHour){
        Duration duration = Duration.between(checkIn,checkOut);
        double totalHours = duration.toHours();
         price = totalHours*pricePerHour;
    }

    public Double getPrice() {
        return price;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle plate=" + vehicle.getRegistrationNumber() +
                ", checkIn=" + checkIn +
                '}';
    }

}
