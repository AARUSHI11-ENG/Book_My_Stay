public abstract class Room {

    protected int beds;
    protected int size;
    protected double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public Room(String single, int i) {
    }

    // Getters
    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Room type (used as key in inventory)
    public String getRoomType() {
        return this.getClass().getSimpleName();
    }

    public abstract void display();
}