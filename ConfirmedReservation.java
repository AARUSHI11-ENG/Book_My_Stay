public class ConfirmedReservation {
    private String guestName;
    private String roomType;
    private String roomId;
    private int nights;
    private boolean cancelled; // new field

    public ConfirmedReservation(String guestName, String roomType, String roomId, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
        this.nights = nights;
        this.cancelled = false;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public String getRoomId() { return roomId; }
    public int getNights() { return nights; }
    public boolean isCancelled() { return cancelled; }

    public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
}