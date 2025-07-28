import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BikeInventory extends VehicleInventory{
    private final List<Bike> bikes;
    public BikeInventory(String storeId) {
        super(storeId, VehicleType.BIKE);
        this.bikes = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getAvailableVehicleList() {
        return this.bikes.stream().filter(bike -> bike.isAvailable()).collect(Collectors.toList());
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() ==  VehicleType.BIKE) {
            this.bikes.add((Bike) vehicle);
            this.vehicleList.add(vehicle);
        }
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() ==  VehicleType.BIKE &&
                this.vehicleList.contains(vehicle) && this.bikes.contains((Bike) vehicle)) {
            this.vehicleList.remove(vehicle);
            this.bikes.remove((Bike) vehicle);
            return true;
        }
        return false;
    }
}
