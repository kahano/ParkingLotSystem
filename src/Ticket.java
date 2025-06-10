import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {


    private final UUID id;
    private final LocalDateTime checkIn;
    private LocalDateTime checkOut;



    private Double price;

    private final Vehicle vehicle;

    public Ticket(Vehicle vehicle){
        id = UUID.randomUUID();
        this.vehicle = vehicle;
        checkIn = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(checkIn, ticket.checkIn) && Objects.equals(checkOut, ticket.checkOut) && Objects.equals(price, ticket.price) && Objects.equals(vehicle, ticket.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkIn, checkOut, price, vehicle);
    }

    public String getId() {
        return id.toString();
    }

    public void setCheckOut(){
        checkOut = LocalDateTime.now();
    }

    public LocalDateTime getCheckOut(){
        return this.checkOut;
    }

    public double getTotalHours(){
        Duration duration = Duration.between(checkIn,checkOut);
        System.out.println("checkOut: " + checkOut);
        return  duration.toHours();

    }

    public void calculateParkingPrice(Double pricePerHour){
        Duration duration = Duration.between(checkIn,checkOut);
        double totalHours = duration.toHours();
        if(totalHours < 1){
            price = 1*pricePerHour;
        }

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
                "Ticket ID= " + this.getId() +
                ", vehicle plate= " + vehicle.getRegistrationNumber() +
                ", checkIn= " + checkIn +
                '}';
    }

}
