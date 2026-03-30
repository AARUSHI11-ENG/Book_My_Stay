public class DeluxeRoom extends Room {

    public DeluxeRoom() {
        super(2, 450, 220);
    }

    @Override
    public void display() {
        System.out.println("Deluxe Room | Luxury | Size: " + size + " sqft");
    }
}