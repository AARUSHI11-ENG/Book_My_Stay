public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // Step 1: Initialize booking history
        BookingHistory history = new BookingHistory();

        // Step 2: Assume some confirmed reservations (from previous Use Case 6)
        ConfirmedReservation res1 = new ConfirmedReservation("Alice", "SingleRoom", "SI-123", 2);
        ConfirmedReservation res2 = new ConfirmedReservation("Bob", "DoubleRoom", "DO-456", 1);
        ConfirmedReservation res3 = new ConfirmedReservation("Diana", "SingleRoom", "SI-789", 1);
        ConfirmedReservation res4 = new ConfirmedReservation("Eve", "DeluxeRoom", "DE-234", 3);

        // Step 3: Add reservations to history
        history.addReservation(res1);
        history.addReservation(res2);
        history.addReservation(res3);
        history.addReservation(res4);

        // Step 4: Initialize reporting service
        BookingReportService reportService = new BookingReportService(history);

        // Step 5: Print full chronological report
        reportService.printBookingReport();

        // Step 6: Print summary report
        reportService.printSummary();
    }
}