import java.util.List;

public interface SlotAssignmentStrategy {
    Slot assignSlot(List<Floor> floors, Vehicle vehicle);
}

