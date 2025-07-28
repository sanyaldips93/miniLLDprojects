import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarInventory extends VehicleInventory{
    private final List<Car> cars;
    public CarInventory(String storeId) {
        super(storeId, VehicleType.CAR);
        this.cars = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getAvailableVehicleList() {
        return this.cars.stream().filter(car -> car.isAvailable()).collect(Collectors.toList());
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() ==  VehicleType.CAR) {
            this.cars.add((Car) vehicle);
            this.vehicleList.add(vehicle);
        }
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() ==  VehicleType.BIKE &&
                this.vehicleList.contains(vehicle) && this.cars.contains((Car) vehicle)) {
            this.vehicleList.remove(vehicle);
            this.cars.remove((Car) vehicle);
            return true;
        }
        return false;
    }
}
