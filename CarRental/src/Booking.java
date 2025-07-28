import java.time.LocalDateTime;

public class Booking {
    private final String storeId;
    private final Vehicle vehicle;
    private final String userId;
    private final String bookingId;
    private final LocalDateTime dateTime;
    private final Double amount;
    private BookingStatus bookingStatus;
    private Payment payment;

    public Booking(String storeId, Vehicle vehicle, String userId, Double amount) {
        this.storeId = storeId;
        this.vehicle = vehicle;
        this.userId = userId;
        this.bookingId = String.valueOf(Math.random());
        this.dateTime = LocalDateTime.now();
        this.amount = amount;
        this.bookingStatus = BookingStatus.ONGOING;
        this.payment = null;
        this.setVehicleAvailability();
    }

    public String getStoreId() {
        return storeId;
    }

    public String getVehicleNo() {
        return this.vehicle.getVehicleNo();
    }

    public String getUserId() {
        return userId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getAmount() {
        return amount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Payment makePayment() {
        this.payment = new Payment(this.bookingId, String.valueOf(Math.random()), this.amount);
        return this.payment;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setVehicleAvailability() {
        this.vehicle.setAvailable(false);
    }
}

