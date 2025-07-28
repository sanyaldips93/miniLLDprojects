import java.util.ArrayList;
import java.util.List;

public abstract class VehicleInventory {
    protected String storeId;
    protected String inventoryId;
    protected VehicleType vehicleType;
    protected List<Vehicle> vehicleList;

    public VehicleInventory(String storeId, VehicleType vehicleType) {
        this.inventoryId = String.valueOf(Math.random());
        this.storeId = storeId;
        this.vehicleType = vehicleType;
        this.vehicleList = new ArrayList<>();
    }

    public String getStoreId() {
        return storeId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public abstract List<Vehicle> getAvailableVehicleList();
    public abstract void addVehicle(Vehicle vehicle);
    public abstract boolean removeVehicle(Vehicle vehicle);
}
