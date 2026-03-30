import java.util.List;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Print a simple chronological booking report
    public void printBookingReport() {
        System.out.println("\n--- Booking History Report ---");

        List<ConfirmedReservation> reservations = history.getAllReservations();

        if (reservations.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (ConfirmedReservation res : reservations) {
            System.out.println("Guest: " + res.getGuestName()
                    + " | Room Type: " + res.getRoomType()
                    + " | Room ID: " + res.getRoomId()
                    + " | Nights: " + res.getNights());
        }

        System.out.println("--- End of Report ---");
    }

    // Generate a summary: total bookings and per-room-type count
    public void printSummary() {
        List<ConfirmedReservation> reservations = history.getAllReservations();

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Total Confirmed Bookings: " + reservations.size());

        reservations.stream()
                .map(ConfirmedReservation::getRoomType)
                .distinct()
                .forEach(type -> {
                    long count = reservations.stream()
                            .filter(r -> r.getRoomType().equals(type))
                            .count();
                    System.out.println("Room Type: " + type + " | Count: " + count);
                });

        System.out.println("--- End of Summary ---");
    }
}