import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ParkingLot {
    private final List<Floor> floors;
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private FeeStrategy feeStrategy;

    public ParkingLot(List<Floor> floors, SlotAssignmentStrategy slotAssignmentStrategy, FeeStrategy feeStrategy) {
        this.floors = floors;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
        this.feeStrategy = feeStrategy;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Slot assignedSlot = this.slotAssignmentStrategy.assignSlot(floors, vehicle);
        if (assignedSlot == null)  {
            System.out.println("No available slots for vehicle = " + vehicle.getLicenseNumber());
            return null;
        }

        Floor floor = floors.stream().filter((f) -> f.getSlotList().contains(assignedSlot)).findFirst().get();
        return new Ticket(vehicle, floor, assignedSlot);
    }


    public double unparkVehicle(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        double fee = this.feeStrategy.calculateFee(ticket.getEntryTime(), exitTime);
        for(Floor floor: floors) {
            for(Slot slot: floor.getSlotList()) {
                if(slot.isOccupied() && Objects.equals(slot.getParkedVehicle().getLicenseNumber(), ticket.getVehicle().getLicenseNumber())) {
                    slot.unpark();
                    System.out.println("Vehicle " + ticket.getVehicle().getLicenseNumber() +
                            " un parked. Fee: " + fee);
                    return fee;
                }
            }
        }
        return 0.0;
    }

    public void setSlotAssignmentStrategy(SlotAssignmentStrategy slotAssignmentStrategy) {
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}
