import java.io.*;
import java.util.List;
import java.util.Map;

public class PersistenceService {

    private static final String INVENTORY_FILE = "inventory.ser";
    private static final String BOOKINGS_FILE = "bookings.ser";

    // Save inventory to file
    public static void saveInventory(Map<String, Integer> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INVENTORY_FILE))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> loadInventory() {
        File file = new File(INVENTORY_FILE);
        if (!file.exists()) {
            System.out.println("No inventory file found. Starting with empty inventory.");
            return new java.util.HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
            return new java.util.HashMap<>();
        }
    }

    // Save booking history to file
    public static void saveBookings(List<Reservation> bookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKINGS_FILE))) {
            oos.writeObject(bookings);
            System.out.println("Booking history saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving booking history: " + e.getMessage());
        }
    }

    // Load booking history from file
    @SuppressWarnings("unchecked")
    public static List<Reservation> loadBookings() {
        File file = new File(BOOKINGS_FILE);
        if (!file.exists()) {
            System.out.println("No booking history file found. Starting with empty history.");
            return new java.util.ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Reservation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading booking history: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
}