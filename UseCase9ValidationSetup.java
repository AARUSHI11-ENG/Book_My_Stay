import java.util.HashMap;
import java.util.Map;

public class UseCase9ValidationSetup {

    public static void main(String[] args) {

        // Sample inventory (room type -> available count)
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("SingleRoom", 2);
        inventory.put("DoubleRoom", 1);
        inventory.put("DeluxeRoom", 0);

        // Sample booking requests
        String[] roomTypes = {"SingleRoom", "SuiteRoom", "DoubleRoom", "DeluxeRoom"};
        int[] requestedCounts = {1, 1, 2, 1};

        for (int i = 0; i < roomTypes.length; i++) {
            try {
                String roomType = roomTypes[i];
                int quantity = requestedCounts[i];

                // Step 1: Validate room type exists
                BookingValidator.validateRoomType(roomType, inventory);

                // Step 2: Validate availability
                BookingValidator.validateAvailability(roomType, quantity, inventory);

                // Step 3: Update inventory (simulating allocation)
                inventory.put(roomType, inventory.get(roomType) - quantity);

                System.out.println("Booking confirmed for " + quantity + " " + roomType + "(s). Remaining: " + inventory.get(roomType));

            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nFinal Inventory State: " + inventory);
    }
}