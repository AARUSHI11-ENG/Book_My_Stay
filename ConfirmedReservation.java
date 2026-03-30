public class ConfirmedReservation {

    private String guestName;
    private String roomType;
    private String roomId;
    private int nights;

    public ConfirmedReservation(String guestName, String roomType, String roomId, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "ConfirmedReservation{" +
                "guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomId='" + roomId + '\'' +
                ", nights=" + nights +
                '}';
    }
}