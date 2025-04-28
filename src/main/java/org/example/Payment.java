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
        if (this.amount > 0) {
            this.status = "Paid";
            return true;
        }
        return false;
    }
    public boolean refund() {
        if (this.amount > 0) {
            this.status = "Refunded";
            return true;
        }
        return false;
    }

    public boolean cancelPayment() {
        if (this.status.equals("Pending")) {
            this.status = "Cancelled";
            return true;
        }
        return false;
    }
    public boolean isPaymentSuccessful() {
        return this.status.equals("Paid");
    }
    public boolean isRefunded() {
        return this.status.equals("Refunded");
    }
    public boolean isCancelled() {
        return this.status.equals("Cancelled");
    }
    public boolean isPending() {
        return this.status.equals("Pending");
    }
    public boolean isPaymentFailed() {
        return this.status.equals("Failed");
    }
    // ✅ Add getters
    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public int getPaymentID() {
        return paymentID;
    }
}