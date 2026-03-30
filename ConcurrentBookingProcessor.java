import java.util.Map;
import java.util.Queue;

public class ConcurrentBookingProcessor implements Runnable {

    private Queue<BookingRequest> bookingQueue;
    private Map<String, Integer> inventory;

    public ConcurrentBookingProcessor(Queue<BookingRequest> bookingQueue, Map<String, Integer> inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            BookingRequest request;

            // Step 1: Retrieve booking request in synchronized block
            synchronized (bookingQueue) {
                if (bookingQueue.isEmpty()) {
                    break;
                }
                request = bookingQueue.poll();
            }

            // Step 2: Allocate room safely
            allocateRoom(request);
        }
    }

    private void allocateRoom(BookingRequest request) {
        String roomType = request.getRoomType();

        synchronized (inventory) { // Critical section for inventory
            int available = inventory.getOrDefault(roomType, 0);
            if (available > 0) {
                inventory.put(roomType, available - 1);
                System.out.println(Thread.currentThread().getName() + " booked " + roomType + " for " + request.getGuestName() +
                        ". Remaining: " + (available - 1));
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to book " + roomType + " for " + request.getGuestName() +
                        ". No rooms available.");
            }
        }
    }
}