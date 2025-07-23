import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    LocalDateTime entryTime;
    Floor floor;
    Slot slot;

    public Ticket(Vehicle vehicle, Floor floor, Slot slot) {
        this.entryTime = LocalDateTime.now();
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Floor getFloor() {
        return floor;
    }

    public Slot getSlot() {
        return slot;
    }
}
