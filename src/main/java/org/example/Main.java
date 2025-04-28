import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> usersCollection;
    private static MongoCollection<Document> ridesCollection;
    private static MongoCollection<Document> paymentsCollection;

    public static void main(String[] args) {
        // Connect to MongoDB
        mongoClient = MongoClients.create("mongodb://localhost:27018");
        database = mongoClient.getDatabase("taxiSharingSystem");

        // Get collections
        usersCollection = database.getCollection("users");
        ridesCollection = database.getCollection("rides");
        paymentsCollection = database.getCollection("payments");

        // Example usage: Register a user, create a ride request, and make a payment
        registerUser("John Doe", "john@example.com", "123456789", "New York");
        Passenger passenger = getPassengerByEmail("john@example.com");

        // Create a ride request
        RideRequest rideRequest = new RideRequest(1, "New York", "Brooklyn", passenger); // Assuming fields are public
        createRideRequest(rideRequest);

        // Make a payment
        Payment payment = new Payment(1, 25.0, "Credit Card"); // Assuming fields are public
        processPayment(payment);
    }

    // Register a user in MongoDB
    public static void registerUser(String name, String email, String phoneNumber, String location) {
        int userID = generateUserID();
        Document user = new Document("userID", userID)
                .append("name", name)
                .append("email", email)
                .append("phoneNumber", phoneNumber)
                .append("location", location);
        usersCollection.insertOne(user);
        System.out.println("User registered: " + name);
    }

    // Retrieve passenger from the database using email
    public static Passenger getPassengerByEmail(String email) {
        Document userDoc = usersCollection.find(Filters.eq("email", email)).first();
        if (userDoc != null && userDoc.containsKey("userID")) {
            return new Passenger(userDoc.getInteger("userID"), userDoc.getString("name"), userDoc.getString("email"),
                    userDoc.getString("phoneNumber"), userDoc.getString("location"), userDoc.getInteger("userID"));
        }
        return null;
    }

    // Create a ride request and store it in MongoDB
    public static void createRideRequest(RideRequest rideRequest) {
        Document rideRequestDoc = new Document("pickupLocation", rideRequest.getPickupLocation()) // Assuming fields are public
                .append("destination", rideRequest.getDestination()) // Accessing via getter
                .append("requestStatus", rideRequest.getRequestStatus()) // Accessing via getter
                .append("passengerID", rideRequest.getPassenger().getUserID()) // Accessing via getter
                .append("requestID", rideRequest.getRequestID()); // Accessing via getter

        ridesCollection.insertOne(rideRequestDoc);
        System.out.println("Ride request created: " + rideRequest.getRequestID());
    }

    // Process payment and store it in MongoDB
    public static void processPayment(Payment payment) {
        Document paymentDoc = new Document("amount", payment.getAmount()) // Accessing via getter
                .append("status", payment.getStatus()) // Accessing via getter
                .append("paymentDate", payment.getPaymentDate()) // Accessing via getter
                .append("method", payment.getMethod()) // Accessing via getter
                .append("paymentID", payment.getPaymentID()); // Accessing via getter

        paymentsCollection.insertOne(paymentDoc);
        System.out.println("Payment processed: " + payment.getPaymentID());
    }

    private static int generateUserID() {
        long count = usersCollection.countDocuments();
        return (int) count + 1;
    }
}