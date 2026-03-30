import java.util.*;

public class AddOnServiceManager {

    // Map reservation ID -> list of services
    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // Attach one or more services to a reservation
    public void addServices(String reservationId, AddOnService... services) {
        List<AddOnService> serviceList = reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>());
        serviceList.addAll(Arrays.asList(services));
        System.out.println("Added services to reservation " + reservationId + ": " + Arrays.toString(services));
    }

    // Retrieve services for a reservation
    public List<AddOnService> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    // Calculate total cost of add-on services for a reservation
    public double calculateTotalAddOnCost(String reservationId) {
        return getServices(reservationId).stream()
                .mapToDouble(AddOnService::getCost)
                .sum();
    }

    // Print all reservations with their services
    public void printAllServices() {
        System.out.println("\n--- Add-On Services per Reservation ---");
        for (Map.Entry<String, List<AddOnService>> entry : reservationServices.entrySet()) {
            System.out.println("Reservation ID: " + entry.getKey() + " | Services: " + entry.getValue());
        }
    }
}