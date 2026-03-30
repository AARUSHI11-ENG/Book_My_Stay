import java.io.Serializable;
import java.util.UUID;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reservationId; // Unique reservation ID
    private String guestName;
    private String roomType;
    private int nights;

    // Constructor generates a unique reservation ID automatically
    public Reservation(String guestName, String roomType, int nights) {
        this.reservationId = generateReservationId();
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Alternative constructor to set a custom reservation ID
    public Reservation(String reservationId, String guestName, String roomType, int nights) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    private String generateReservationId() {
        // Generates a unique ID like "RES-xxxx-xxxx"
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Getters
    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", nights=" + nights +
                '}';
    }
}