/**
 * UseCase2RoomInitialization
 * 
 * Demonstrates abstraction, inheritance, and static availability
 * for different room types.
 * 
 * @author Aarushi
 * @version 2.1
 */

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        single.display();
        System.out.println("Available: " + singleAvailable);

        dbl.display();
        System.out.println("Available: " + doubleAvailable);

        suite.display();
        System.out.println("Available: " + suiteAvailable);
    }
}