import java.util.ArrayList;
import java.util.List;

public class Ride {
    private int rideID;
    private String startTime;
    private String endTime;
    private List<String> route;
    private double fare;
    private String status;

    public Ride(int rideID, String startTime) {
        this.rideID = rideID;
        this.startTime = startTime;
        this.route = new ArrayList<>();
        this.status = "Started";
    }

    public void endRide(String endTime) {
        this.endTime = endTime;
        this.status = "Completed";
    }

    public void addStop(String location) {
        route.add(location);
    }

    public int getDuration() {
        return 30; // dummy duration
    }

    public void calculateFare() {
        this.fare = 5.0 + route.size() * 2;
    }

    public double getFare() {
        return fare;
    }
}