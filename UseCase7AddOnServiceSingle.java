import java.util.*;

public class UseCase7AddOnServiceSingle {
    public static void main(String[] args) {

        // Reservation ID
        String reservationId = "SINGLE-001";

        // Initialize manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Add multiple services to this reservation
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa Access", 500);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 500);

        manager.addServices(reservationId, breakfast, spa, airportPickup);

        // Calculate total add-on cost
        double totalCost = manager.calculateTotalAddOnCost(reservationId);

        // Display the output
        System.out.println("AddOnService Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}