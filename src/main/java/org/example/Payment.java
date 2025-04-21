import java.time.LocalDate;

public class Payment {
    private int paymentID;
    private double amount;
    private String status;
    private LocalDate paymentDate;
    private String method;

    public Payment(int paymentID, double amount, String method) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.method = method;
        this.status = "Pending";
        this.paymentDate = LocalDate.now();
    }

    public boolean processPayment() {
        this.status = "Paid";
        return true;
    }

    public boolean refund() {
        this.status = "Refunded";
        return true;
    }
}