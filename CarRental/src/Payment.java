import java.time.LocalDateTime;

public class Payment {
    private final String bookingId;
    private final String paymentId;
    private LocalDateTime paymentDate;
    private final Double paymentAmount;
    private PaymentStatus paymentStatus;

    public Payment(String bookingId, String paymentId, Double paymentAmount) {
        this.bookingId = bookingId;
        this.paymentId = paymentId;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
        if (paymentStatus == PaymentStatus.PAID) {
            this.paymentDate = LocalDateTime.now();
        }
    }

    public void createPayment() {
        this.setPaymentStatus(PaymentStatus.PAID);
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
