import java.util.Map;

public class BookingValidator {

    // Validate room type exists in inventory
    public static void validateRoomType(String roomType, Map<String, Integer> inventory) throws InvalidBookingException {
        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Error: Invalid room type '" + roomType + "'.");
        }
    }

    // Validate requested quantity does not exceed available inventory
    public static void validateAvailability(String roomType, int requestedQuantity, Map<String, Integer> inventory) throws InvalidBookingException {
        int available = inventory.getOrDefault(roomType, 0);
        if (requestedQuantity <= 0) {
            throw new InvalidBookingException("Error: Requested quantity must be at least 1.");
        }
        if (requestedQuantity > available) {
            throw new InvalidBookingException("Error: Only " + available + " room(s) available for type '" + roomType + "'. Requested: " + requestedQuantity);
        }
    }
}