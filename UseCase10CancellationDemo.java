import java.util.*;

public class UseCase10CancellationDemo {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("SingleRoom", 1);
        inventory.put("DoubleRoom", 1);

        // Step 2: Initialize booking history with confirmed reservations
        BookingHistory bookingHistory = new BookingHistory();

        ConfirmedReservation res1 = new ConfirmedReservation("Alice", "SingleRoom", "SI-101", 2);
        ConfirmedReservation res2 = new ConfirmedReservation("Bob", "DoubleRoom", "DO-201", 1);
        bookingHistory.addReservation(res1);
        bookingHistory.addReservation(res2);

        // Step 3: Initialize cancellation service
        CancellationService cancellationService = new CancellationService(inventory, bookingHistory);

        // Step 4: Cancel a reservation
        cancellationService.cancelBooking("SI-101"); // valid cancellation

        // Step 5: Attempt invalid cancellation
        cancellationService.cancelBooking("SI-101"); // already cancelled
        cancellationService.cancelBooking("XX-999"); // non-existent room

        // Step 6: View released room IDs
        cancellationService.viewReleasedRoomIds();

        // Step 7: Check updated inventory
        System.out.println("Updated Inventory: " + inventory);
    }
}