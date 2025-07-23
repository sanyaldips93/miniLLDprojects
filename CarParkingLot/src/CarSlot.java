public class CarSlot extends Slot{
    public CarSlot(int slotNumber) {
        super(slotNumber);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.vehicleType == VehicleType.CAR || vehicle.vehicleType == VehicleType.BIKE;
    }
}
