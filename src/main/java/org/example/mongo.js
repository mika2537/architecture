import { MongoClient } from "mongodb";

const url = "mongodb://localhost:27018"; // MongoDB connection URL
const dbName = "taxiSharingSystem"; // Database name

// Create a new MongoClient
const client = new MongoClient(url, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

async function main() {
  try {
    // Connect to MongoDB
    await client.connect();
    console.log("Connected to MongoDB!");

    // Get the database
    const db = client.db(dbName);

    // Define the collections for each class
    const usersCollection = db.collection("users");
    const passengersCollection = db.collection("passengers");
    const driversCollection = db.collection("drivers");
    const rideRequestsCollection = db.collection("rideRequests");
    const ridesCollection = db.collection("rides");
    const vehiclesCollection = db.collection("vehicles");
    const paymentsCollection = db.collection("payments");

    // Insert data for each class (5 entries per collection)

    // Users
    await usersCollection.insertMany([
      {
        userID: 1,
        name: "John Doe",
        email: "john.doe@example.com",
        phoneNumber: "123-456-7890",
        location: "Downtown",
        type: "Passenger",
      },
      {
        userID: 2,
        name: "Jane Smith",
        email: "jane.smith@example.com",
        phoneNumber: "987-654-3210",
        location: "Uptown",
        type: "Passenger",
      },
      {
        userID: 3,
        name: "Alice Johnson",
        email: "alice.johnson@example.com",
        phoneNumber: "555-555-5555",
        location: "Midtown",
        type: "Driver",
      },
      {
        userID: 4,
        name: "Bob Lee",
        email: "bob.lee@example.com",
        phoneNumber: "111-222-3333",
        location: "Downtown",
        type: "Driver",
      },
      {
        userID: 5,
        name: "Eve White",
        email: "eve.white@example.com",
        phoneNumber: "444-555-6666",
        location: "Suburbs",
        type: "Passenger",
      },
    ]);

    // Passengers
    await passengersCollection.insertMany([
      { passengerID: 101, userID: 1, requestedRideID: null },
      { passengerID: 102, userID: 2, requestedRideID: null },
      { passengerID: 103, userID: 5, requestedRideID: null },
      { passengerID: 104, userID: 3, requestedRideID: null },
      { passengerID: 105, userID: 4, requestedRideID: null },
    ]);

    // Drivers
    await driversCollection.insertMany([
      {
        driverID: 201,
        userID: 3,
        licenseNumber: "AB12345",
        vehicle: {
          vehicleID: 301,
          licensePlate: "XYZ-1234",
          make: "Toyota",
          model: "Corolla",
          capacity: 4,
        },
      },
      {
        driverID: 202,
        userID: 4,
        licenseNumber: "CD67890",
        vehicle: {
          vehicleID: 302,
          licensePlate: "ABC-5678",
          make: "Honda",
          model: "Civic",
          capacity: 4,
        },
      },
      {
        driverID: 203,
        userID: 6,
        licenseNumber: "EF11112",
        vehicle: {
          vehicleID: 303,
          licensePlate: "DEF-1234",
          make: "Ford",
          model: "Focus",
          capacity: 4,
        },
      },
      {
        driverID: 204,
        userID: 7,
        licenseNumber: "GH34567",
        vehicle: {
          vehicleID: 304,
          licensePlate: "GHI-3456",
          make: "Nissan",
          model: "Altima",
          capacity: 4,
        },
      },
      {
        driverID: 205,
        userID: 8,
        licenseNumber: "IJ78901",
        vehicle: {
          vehicleID: 305,
          licensePlate: "JKL-7890",
          make: "Chevrolet",
          model: "Malibu",
          capacity: 4,
        },
      },
    ]);

    // Ride Requests
    await rideRequestsCollection.insertMany([
      {
        requestID: 401,
        pickupLocation: "Downtown",
        destination: "Airport",
        requestStatus: "Pending",
        passengerID: 101,
        driverID: 201,
      },
      {
        requestID: 402,
        pickupLocation: "Uptown",
        destination: "Station",
        requestStatus: "Pending",
        passengerID: 102,
        driverID: 202,
      },
      {
        requestID: 403,
        pickupLocation: "Midtown",
        destination: "Park",
        requestStatus: "Pending",
        passengerID: 103,
        driverID: 203,
      },
      {
        requestID: 404,
        pickupLocation: "Downtown",
        destination: "Mall",
        requestStatus: "Pending",
        passengerID: 104,
        driverID: 204,
      },
      {
        requestID: 405,
        pickupLocation: "Suburbs",
        destination: "Beach",
        requestStatus: "Pending",
        passengerID: 105,
        driverID: 205,
      },
    ]);

    // Rides
    await ridesCollection.insertMany([
      {
        rideID: 501,
        startTime: new Date(),
        endTime: null,
        route: ["Downtown", "Airport"],
        fare: 25.5,
        status: "In Progress",
      },
      {
        rideID: 502,
        startTime: new Date(),
        endTime: null,
        route: ["Uptown", "Station"],
        fare: 15.0,
        status: "In Progress",
      },
      {
        rideID: 503,
        startTime: new Date(),
        endTime: null,
        route: ["Midtown", "Park"],
        fare: 12.5,
        status: "In Progress",
      },
      {
        rideID: 504,
        startTime: new Date(),
        endTime: null,
        route: ["Downtown", "Mall"],
        fare: 20.0,
        status: "In Progress",
      },
      {
        rideID: 505,
        startTime: new Date(),
        endTime: null,
        route: ["Suburbs", "Beach"],
        fare: 30.0,
        status: "In Progress",
      },
    ]);

    // Vehicles
    await vehiclesCollection.insertMany([
      {
        vehicleID: 301,
        licensePlate: "XYZ-1234",
        make: "Toyota",
        model: "Corolla",
        capacity: 4,
      },
      {
        vehicleID: 302,
        licensePlate: "ABC-5678",
        make: "Honda",
        model: "Civic",
        capacity: 4,
      },
      {
        vehicleID: 303,
        licensePlate: "DEF-1234",
        make: "Ford",
        model: "Focus",
        capacity: 4,
      },
      {
        vehicleID: 304,
        licensePlate: "GHI-3456",
        make: "Nissan",
        model: "Altima",
        capacity: 4,
      },
      {
        vehicleID: 305,
        licensePlate: "JKL-7890",
        make: "Chevrolet",
        model: "Malibu",
        capacity: 4,
      },
    ]);

    // Payments
    await paymentsCollection.insertMany([
      {
        paymentID: 601,
        amount: 25.5,
        status: "Paid",
        paymentDate: new Date(),
        method: "Credit Card",
      },
      {
        paymentID: 602,
        amount: 15.0,
        status: "Paid",
        paymentDate: new Date(),
        method: "Cash",
      },
      {
        paymentID: 603,
        amount: 12.5,
        status: "Paid",
        paymentDate: new Date(),
        method: "Credit Card",
      },
      {
        paymentID: 604,
        amount: 20.0,
        status: "Paid",
        paymentDate: new Date(),
        method: "Debit Card",
      },
      {
        paymentID: 605,
        amount: 30.0,
        status: "Paid",
        paymentDate: new Date(),
        method: "Credit Card",
      },
    ]);

    console.log("Data inserted successfully!");

    // Fetch and display the data
    const users = await usersCollection.find().toArray();
    console.log("Users:", users);

    const passengers = await passengersCollection.find().toArray();
    console.log("Passengers:", passengers);

    const drivers = await driversCollection.find().toArray();
    console.log("Drivers:", drivers);

    const rideRequests = await rideRequestsCollection.find().toArray();
    console.log("Ride Requests:", rideRequests);

    const rides = await ridesCollection.find().toArray();
    console.log("Rides:", rides);

    const vehicles = await vehiclesCollection.find().toArray();
    console.log("Vehicles:", vehicles);

    const payments = await paymentsCollection.find().toArray();
    console.log("Payments:", payments);
  } catch (err) {
    console.error("Error connecting to MongoDB:", err);
  } finally {
    // Close the MongoDB connection
    await client.close();
  }
}

// Run the main function
main();
