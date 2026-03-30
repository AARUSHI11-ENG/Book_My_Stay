class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }

    public void display() {
        System.out.println("\nSuite Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}