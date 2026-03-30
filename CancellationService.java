import java.util.*;

public class CancellationService {

    // Stack to track released room IDs (LIFO)
    private Stack<String> releasedRoomIds = new Stack<>();

    // Reference to inventory and booking history
    private Map<String, Integer> inventory;
    private BookingHistory bookingHistory;

    public CancellationService(Map<String, Integer> inventory, BookingHistory bookingHistory) {
        this.inventory = inventory;
        this.bookingHistory = bookingHistory;
    }

    // Cancel a reservation by room ID
    public void cancelBooking(String roomId) {
        List<ConfirmedReservation> allReservations = bookingHistory.getAllReservations();
        Optional<ConfirmedReservation> reservationOpt = allReservations.stream()
                .filter(r -> r.getRoomId().equals(roomId) && !r.isCancelled())
                .findFirst();

        if (reservationOpt.isEmpty()) {
            System.out.println("Error: Reservation with Room ID '" + roomId + "' does not exist or is already cancelled.");
            return;
        }

        ConfirmedReservation reservation = reservationOpt.get();

        // Step 1: Record released room ID in stack
        releasedRoomIds.push(reservation.getRoomId());

        // Step 2: Restore inventory
        String roomType = reservation.getRoomType();
        inventory.put(roomType, inventory.getOrDefault(roomType, 0) + 1);

        // Step 3: Mark reservation as cancelled
        reservation.setCancelled(true);

        System.out.println("Booking with Room ID '" + roomId + "' cancelled successfully. Inventory restored.");
    }

    // Optional: View released room IDs stack
    public void viewReleasedRoomIds() {
        System.out.println("Released Room IDs (most recent first): " + releasedRoomIds);
    }
}