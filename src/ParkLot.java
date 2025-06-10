import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkLot {


    private double hourPrice;
    private String name;
    private final List<ParkingSpot> parks;

    public ParkLot(double hourPrice, String name, int spots) {
        this.hourPrice = hourPrice;
        this.name = name;
        parks = new ArrayList<>(spots);
        for(int i = 1; i < spots+1;i++) {

            ParkingType type = ParkingType.NORMAL;
            if (i % 10 == 0) {
                type = ParkingType.HANDICAP;
            } else if (i % 5 == 0) {
                type = ParkingType.EV;
            }
            parks.add(new ParkingSpot(i, true, type));
        }

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



    public List<ParkingSpot> getParkSpots(){
        return parks;
    }


    public Integer findAvailableSpot(VehicleType vType, ParkingType pType){

        for(ParkingSpot spot: parks) {
            if(spot.getParkingType().equalsIgnoreCase(pType.name()) &&
                    spot.isParkAvailable()) {

                return spot.getSpotNumber();
            }
        }
        throw new IllegalStateException("No Available " + pType + " spots for " + vType);
    }






}
