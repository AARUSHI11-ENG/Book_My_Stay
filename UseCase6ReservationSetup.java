import java.util.Arrays;
import java.util.List;

public class UseCase6ReservationSetup {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Prepare some room availability
        inventory.updateAvailability("SingleRoom", 2);
        inventory.updateAvailability("DoubleRoom", 1);
        inventory.updateAvailability("DeluxeRoom", 1);
        inventory.updateAvailability("SuiteRoom", 0);

        // Step 3: Initialize booking request queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests
        bookingQueue.addRequest(new Reservation("Alice", "SingleRoom", 2));
        bookingQueue.addRequest(new Reservation("Bob", "DoubleRoom", 1));
        bookingQueue.addRequest(new Reservation("Charlie", "SuiteRoom", 1));
        bookingQueue.addRequest(new Reservation("Diana", "SingleRoom", 1));
        bookingQueue.addRequest(new Reservation("Eve", "DeluxeRoom", 3));
        bookingQueue.addRequest(new Reservation("Frank", "SingleRoom", 2));

        // Step 4: Allocate rooms
        RoomAllocationService allocationService = new RoomAllocationService(inventory, bookingQueue);
        allocationService.processBookings();

        // Step 5: Print all allocations
        allocationService.printAllocatedRooms();

        // Step 6: Print remaining inventory
        System.out.println("\n--- Remaining Inventory ---");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count));
    }
}
