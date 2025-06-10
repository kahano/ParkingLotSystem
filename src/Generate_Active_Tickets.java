import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Generate_Active_Tickets {
    private final ActiveParking park;
    private final List<Ticket> tickets = new ArrayList<>();
    private final Scanner sc;
    private boolean running = true;

    public Generate_Active_Tickets(ActiveParking park) {
        this.park = park;
        this.sc = new Scanner(System.in);
    }

    private void park() {
        try {

            System.out.println("\nWrite in your registration Number: ");
            String plate = sc.nextLine().trim();

            if(!IsvehicleParked(plate)){


                System.out.println("\nCar type: ");
                VehicleType[] vehicleTypes = VehicleType.values();
                for (VehicleType vehicle : vehicleTypes) {
                    System.out.println(vehicle.ordinal() + "- " + vehicle);
                }

                System.out.println("\nParktype: ");
                ParkingType[] parkTypes = ParkingType.values();
                for (ParkingType parking : parkTypes) {
                    System.out.println(parking.ordinal() + "- " + parking);
                }

                System.out.println("\nPick one Vehicle type: ");
                int vTypeResult = Integer.parseInt(sc.nextLine());

                System.out.println("\nPick one Parking type: ");
                int pTypeResult = Integer.parseInt(sc.nextLine());

                if ((vTypeResult >= 0 && vTypeResult < vehicleTypes.length) &&
                        (pTypeResult >= 0 && pTypeResult < parkTypes.length)) {

                    Vehicle vehicle = new Vehicle(plate, vehicleTypes[vTypeResult]);
                    ParkingType requestedType = parkTypes[pTypeResult];

                    try {
                        Integer spotNumber = park.getParklot().findAvailableSpot(vehicleTypes[vTypeResult], parkTypes[pTypeResult]);
                        boolean isParked = park.parkVehicle(vehicle, spotNumber);

                        if (isParked) {
                            System.out.println("\nParking started at spot " + spotNumber);
                            tickets.add(new Ticket(vehicle));
                            System.out.println("Vehicle parked successfully!\n");
                        } else {
                            System.out.println("\nNo spot is available");
                        }
                    } catch (IllegalStateException e) {
                        System.out.println("\nNo available " + requestedType + " spots for " + vehicle.getVehicleType());
                    }
                } else {
                    System.out.println("\nInvalid selection. Please try again.");
                }

            }else{

                System.out.println("\nThe vehicle with the given registration number: " + plate + " is already registered parking.");
            }


        } catch (NumberFormatException e) {
            System.out.println("\nPlease enter a valid number");
        }
    }


    private void leaveParkingSpace() {
        System.out.println("\nEnter the registration number: ");
        String plate = sc.nextLine().trim();

        Iterator<Ticket> iterator = tickets.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getVehicle().getRegistrationNumber().equalsIgnoreCase(plate)) {
                try {
                    Vehicle parkedVehicle = park.unParkVehicle(plate);
                    ticket.setCheckOut();
                 System.out.println("\n" + ticket.toString()+"\n");
                    System.out.println("Exit parking\n");
                    double price = park.getParklot().getHourPrice();

                    if (ticket.getTotalHours() > park.getMaxHours()) {
                        price += 1000; // adding a fine for violation
                        System.out.println("Exceeded maximum parking time! Additional fine applied.");
                    }

                    ticket.calculateParkingPrice(price);
                    System.out.println("Total fee for parking: " + ticket.getPrice() + " Krones");
                    iterator.remove();
                    found = true;
                    break;
                } catch (IllegalStateException e) {
                    System.out.println("\nError processing ticket: " + e.getMessage());
                }
            }
        }

        if (!found) {
            System.out.println("\nNo vehicle found with registration: " + plate);
        }
    }

    private void displayActiveTickets() {
        System.out.println("\nActive tickets:\n");
        if (tickets.isEmpty()) {
            System.out.println("No active tickets available.");
        } else {
            tickets.forEach(System.out::println);
            System.out.println("Total available ParkingSpots: " + park.getTotalAvailableParkingSpots());
        }
    }

    private boolean IsvehicleParked(String plateNumber){

        return tickets.stream().anyMatch(ticket -> ticket.getVehicle().getRegistrationNumber().equals(plateNumber));
    }

    public void parkingMenu() {
        while (running) {
            System.out.println("\n--- Parking App Menu ---");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Retrieve a vehicle");
            System.out.println("3. View all active tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        park();
                        break;
                    case 2:
                        leaveParkingSpace();
                        break;
                    case 3:
                        displayActiveTickets();
                        break;
                    case 4:
                        System.out.println("\nExiting the Parking App. Goodbye!");
                        running = false;
                        sc.close();
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a number between 1 and 4");
            }
        }
    }
}