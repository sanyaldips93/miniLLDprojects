public class Location {
    private final String streetName;
    private final String pinCode;
    private final String houseNumber;
    private final String city;
    private final String state;
    private final String country;
    private final Double latitude;
    private final Double longitude;

    public Location(String streetName, String pinCode, String houseNumber, String city, String state, String country, Double latitude, Double longitude) {
        this.streetName = streetName;
        this.pinCode = pinCode;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
