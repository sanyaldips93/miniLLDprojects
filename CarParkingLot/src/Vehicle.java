public class Vehicle {
    private final String licenseNumber;
    public final VehicleType vehicleType;
    public Vehicle(VehicleType vehicleType, String licenseNumber) {
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
