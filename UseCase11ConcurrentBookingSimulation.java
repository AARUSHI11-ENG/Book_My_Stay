import java.util.*;

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) throws InterruptedException {

        // Step 1: Shared inventory
        Map<String, Integer> inventory = Collections.synchronizedMap(new HashMap<>());
        inventory.put("SingleRoom", 2);
        inventory.put("DoubleRoom", 1);

        // Step 2: Shared booking queue
        Queue<BookingRequest> bookingQueue = new LinkedList<>();
        bookingQueue.add(new BookingRequest("Alice", "SingleRoom"));
        bookingQueue.add(new BookingRequest("Bob", "DoubleRoom"));
        bookingQueue.add(new BookingRequest("Charlie", "SingleRoom"));
        bookingQueue.add(new BookingRequest("Dave", "SingleRoom")); // Should fail if no room left
        bookingQueue.add(new BookingRequest("Eve", "DoubleRoom")); // Should fail if no room left

        // Step 3: Create threads simulating multiple guests booking concurrently
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory), "Thread-1");
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory), "Thread-2");
        Thread t3 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory), "Thread-3");

        // Step 4: Start threads
        t1.start();
        t2.start();
        t3.start();

        // Step 5: Wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

        // Step 6: Print final inventory
        System.out.println("\nFinal Inventory: " + inventory);
    }
}