import java.sql.Driver;

public class RideRequest {
    public int requestID;
    private String pickupLocation;
    private String destination;
    private String requestStatus;
    private Passenger passenger;
    private Driver driver;

    public RideRequest(int requestID, String pickupLocation, String destination, Passenger passenger) {
        this.requestID = requestID;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.passenger = passenger;
        this.requestStatus = "Pending";
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.requestStatus = "Accepted";
    }

    public void updateStatus(String status) {
        this.requestStatus = status;
    }

    public double getEstimatedCost() {
        return 10.0 + pickupLocation.length() * 0.5 + destination.length() * 0.7;
    }
}