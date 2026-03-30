class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }

    public void display() {
        System.out.println("\nDouble Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}