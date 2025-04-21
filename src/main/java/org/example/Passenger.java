public class Passenger extends User {
    private int passengerID;

    public Passenger(int userID, String name, String email, String phoneNumber, String location, int passengerID) {
        super(userID, name, email, phoneNumber, location);
        this.passengerID = passengerID;
    }

    public void requestRide(String location, String destination) {
        System.out.println("Ride requested from " + location + " to " + destination);
    }

    public void cancelRide(int requestID) {
        System.out.println("Ride request " + requestID + " canceled.");
    }

    public void rateDriver(int driverID, int rating) {
        System.out.println("Rated driver " + driverID + " with " + rating + " stars.");
    }
}