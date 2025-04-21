public class User {
    protected int userID;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String location;

    public User(int userID, String name, String email, String phoneNumber, String location) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public void register() {
        System.out.println("User registered: " + name);
    }

    public boolean login(String email, String password) {
        // Dummy login validation
        return this.email.equals(email);
    }

    public void updateProfile(String name, String phoneNumber, String location) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        System.out.println("Profile updated for: " + userID);
    }
}