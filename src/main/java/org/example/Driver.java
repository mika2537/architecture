public class Driver extends User {
    private int driverID;
    private String licenseNumber;
    private Vehicle vehicle;

    public Driver(int userID, String name, String email, String phoneNumber, String location, int driverID, String licenseNumber, Vehicle vehicle) {
        super(userID, name, email, phoneNumber, location);
        this.driverID = driverID;
        this.licenseNumber = licenseNumber;
        this.vehicle = vehicle;
    }

    public void acceptRide(int requestID) {
        System.out.println("Ride request " + requestID + " accepted.");
    }

    public void completeRide(int rideID) {
        System.out.println("Ride " + rideID + " completed.");
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
        System.out.println("Driver location updated to: " + newLocation);
    }
}