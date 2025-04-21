public class Vehicle {
    private int vehicleID;
    private String licensePlate;
    private String make;
    private String model;
    private int capacity;
    private boolean isAvailable;

    public Vehicle(int vehicleID, String licensePlate, String make, String model, int capacity) {
        this.vehicleID = vehicleID;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public String getDetails() {
        return make + " " + model + " (" + licensePlate + ")";
    }

    public void updateAvailability(boolean status) {
        this.isAvailable = status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}