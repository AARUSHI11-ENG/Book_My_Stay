import java.util.Arrays;
import java.util.List;

public class UseCase4SearchSetup {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Use your existing Room class
        List<Room> rooms = Arrays.asList(
                new SingleRoom(),
                new DoubleRoom(),
                new DeluxeRoom(),
                new SuiteRoom()
        );

        // Step 3: Make one room unavailable
        inventory.updateAvailability("Suite", 0);

        // Step 4: Search (READ-ONLY)
        RoomSearchService searchService =
                new RoomSearchService(inventory, rooms);

        searchService.searchAvailableRooms();
    }
}