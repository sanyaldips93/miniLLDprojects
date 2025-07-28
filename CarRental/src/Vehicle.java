public abstract class Vehicle {
    private final String vehicleNo;
    private final String name;
    private boolean isAvailable;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleNo, String name, boolean isAvailable, VehicleType vehicleType) {
        this.isAvailable = true;
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
