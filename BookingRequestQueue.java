import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a reservation to the queue
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);  // FIFO: earliest request at head
        System.out.println("Booking request added: " + reservation.getGuestName()
                + " for " + reservation.getRoomType());
    }

    // Peek at the next reservation (without removing)
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    // Process and remove the next request from the queue
    public Reservation processNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    // Get current queue size
    public int getQueueSize() {
        return requestQueue.size();
    }
}
