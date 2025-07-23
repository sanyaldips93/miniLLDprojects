public abstract class Slot {
    private final int slotNumber;
    private boolean isOccupied;
    private Vehicle currentVehicle;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public boolean park(Vehicle vehicle) {
        if(!this.isOccupied && canFitVehicle(vehicle)) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void unpark() {
        this.isOccupied = false;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getParkedVehicle() {
        return currentVehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
