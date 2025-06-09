public class Vehicle {


    private String registrationNumber;
    private VehicleType vehicleType;

    public Vehicle(String registrationNumber){
        this(registrationNumber,VehicleType.SEDAN);
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType.name().toLowerCase();
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }




}
