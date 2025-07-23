import java.util.List;

public class FirstAvailableSlotStrategy implements SlotAssignmentStrategy {
    public Slot assignSlot(List<Floor> floors, Vehicle vehicle) {
        for (Floor floor : floors) {
            for (Slot slot : floor.getSlotList()) {
                if (!slot.isOccupied() && slot.canFitVehicle(vehicle)) {
                    slot.park(vehicle);
                    System.out.println("Parked at floor " + floor.getFloorNumber() + ", slot " + slot.getSlotNumber());
                    return slot;
                }
            }
        }
        System.out.println("No available slot for vehicle: " + vehicle.getLicenseNumber());
        return null;
    }
}
