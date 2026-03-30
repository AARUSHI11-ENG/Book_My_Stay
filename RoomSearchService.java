import java.util.List;
import java.util.Map;

/**
 * Handles read-only search operations.
 * Does NOT modify inventory.
 */
public class RoomSearchService {

    private RoomInventory inventory;
    private List<Room> rooms;

    public RoomSearchService(RoomInventory inventory, List<Room> rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    /**
     * Displays only available rooms (availability > 0)
     */
    public void searchAvailableRooms() {

        System.out.println("\n--- Available Rooms ---");

        Map<String, Integer> availability = inventory.getRoomAvailability();

        for (Room room : rooms) {

            int count = availability.getOrDefault(room.getRoomType(), 4);

            // Only show rooms that are available
            if (count > 0) {

                // Use your existing Room methods here
                room.display();  // assuming you already have this

                System.out.println("Available Count: " + count);
                System.out.println("-----------------------------------");
            }
        }
    }
}