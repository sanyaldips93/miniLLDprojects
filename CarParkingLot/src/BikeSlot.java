public class BikeSlot extends Slot{
    public BikeSlot(int slotNumber) {
        super(slotNumber);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.vehicleType == VehicleType.BIKE;
    }
}
