import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final String storeId;
    private final String storeName;
    private final Location location;
    private final List<VehicleInventory> vehicleInventoryList;
    // private List<Booking> bookingList;

    public Store(String storeName, String storeId, Location location) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.vehicleInventoryList = new ArrayList<>();
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public Location getLocation() {
        return location;
    }

    public List<VehicleInventory> getVehicleInventoryList() {
        return vehicleInventoryList;
    }

    public List<Vehicle> getAllAvailableVehicles(VehicleType vehicleType) {
        return this.vehicleInventoryList.stream()
                .filter(inv -> inv.getVehicleType() == vehicleType)
                .flatMap(inv -> inv.getAvailableVehicleList().stream())
                .collect(Collectors.toList());
    }

    public void addInventory(VehicleInventory vehicleInventory) {
        if (!this.vehicleInventoryList.contains(vehicleInventory)) {
            this.vehicleInventoryList.add(vehicleInventory);
        }
    }

    public boolean removeInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventoryList.remove(vehicleInventory);
        return true;
    }

}
