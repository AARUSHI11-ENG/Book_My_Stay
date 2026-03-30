import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    // Maintains booking records in order of confirmation
    private List<ConfirmedReservation> confirmedBookings;

    public BookingHistory() {
        this.confirmedBookings = new ArrayList<>();
    }

    // Add a confirmed reservation to history
    public void addReservation(ConfirmedReservation reservation) {
        confirmedBookings.add(reservation);
    }

    // Retrieve all confirmed reservations
    public List<ConfirmedReservation> getAllReservations() {
        return new ArrayList<>(confirmedBookings); // return a copy to prevent modification
    }

    // Check if history is empty
    public boolean isEmpty() {
        return confirmedBookings.isEmpty();
    }
}