import java.util.List;

public class Floor {
    private final List<Slot> slotList;
    private final int floorNumber;

    public Floor(int floorNumber, List<Slot> slotList) {
        this.floorNumber = floorNumber;
        this.slotList = slotList;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
