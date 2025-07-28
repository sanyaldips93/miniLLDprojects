public class User {
    private final String userId;
    private final String name;
    private final String driverLicenseNumber;

    public User(String name, String driverLicenseNumber, String userId) {
        this.driverLicenseNumber = driverLicenseNumber;
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getUserId() {
        return userId;
    }
}
