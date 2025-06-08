import java.util.List;
import java.util.Optional;

public class ParkLot {




    private double hourPrice;
    private String name;
    private List<ParkingSpot> parks;
    private int totalParkingSpots;

    public ParkLot(double hourPrice, String name) {
        this.hourPrice = hourPrice;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHourPrice(double price){
        this.hourPrice = price;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        for(int i = 0; i < totalParkingSpots;i++){
            parkingSpot.setSpotNumber(i);
            parks.add(parkingSpot);
        }
    }

    public List<ParkingSpot> getParkSpots(){
        return parks;
    }




}
