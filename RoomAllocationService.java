import java.util.*;

public class RoomAllocationService {

    private RoomInventory inventory;
    private BookingRequestQueue requestQueue;

    // Map room type -> allocated room IDs
    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService(RoomInventory inventory, BookingRequestQueue requestQueue) {
        this.inventory = inventory;
        this.requestQueue = requestQueue;
        this.allocatedRooms = new HashMap<>();
    }

    // Process all queued booking requests
    public void processBookings() {
        System.out.println("\n--- Processing Bookings ---");

        while (!requestQueue.isEmpty()) {
            Reservation request = requestQueue.processNextRequest();

            String roomType = request.getRoomType();
            int availableCount = inventory.getRoomAvailability().getOrDefault(roomType, 0);

            if (availableCount > 0) {
                // Generate a unique room ID
                String roomId = generateUniqueRoomId(roomType);

                // Record allocation
                allocatedRooms.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, availableCount - 1);

                ConfirmedReservation confirmed = new ConfirmedReservation(
                        request.getGuestName(),
                        roomType,
                        roomId,
                        request.getNights()
                );

                System.out.println("Confirmed: " + confirmed);

            } else {
                System.out.println("Sorry, no availability for " + request.getGuestName() +
                        " requesting " + roomType);
            }
        }
    }

    // Generate unique room ID for the given type
    private String generateUniqueRoomId(String roomType) {
        String id;
        Set<String> allocated = allocatedRooms.getOrDefault(roomType, new HashSet<>());

        do {
            id = roomType.substring(0, 2).toUpperCase() + "-" + (new Random().nextInt(900) + 100);
        } while (allocated.contains(id));

        return id;
    }

    // For reporting: view all allocated rooms
    public void printAllocatedRooms() {
        System.out.println("\n--- Allocated Rooms ---");
        for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
            System.out.println("Room Type: " + entry.getKey() + " | Room IDs: " + entry.getValue());
        }
    }
}