public class UseCase5BookingSetup {

    public static void main(String[] args) {

        // Step 1: Initialize booking request queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Step 2: Guests submit booking requests
        bookingQueue.addRequest(new Reservation("Alice", "SingleRoom", 2));
        bookingQueue.addRequest(new Reservation("Bob", "DoubleRoom", 3));
        bookingQueue.addRequest(new Reservation("Charlie", "SuiteRoom", 1));
        bookingQueue.addRequest(new Reservation("Diana", "DeluxeRoom", 2));

        System.out.println("\nTotal requests in queue: " + bookingQueue.getQueueSize());

        // Step 3: Peek at the next request without removing
        System.out.println("Next request to process: " + bookingQueue.peekNextRequest());

        // Step 4: Process requests in FIFO order
        System.out.println("\nProcessing booking requests...");
        while (!bookingQueue.isEmpty()) {
            Reservation res = bookingQueue.processNextRequest();
            System.out.println("Processing: " + res.getGuestName() + " for " + res.getRoomType());
        }

        System.out.println("\nAll requests processed. Queue empty? " + bookingQueue.isEmpty());
    }
}