import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Car car1 = new Car("Bolero", "ABED_123", true);
        Car car2 = new Car("Bolero", "ABLE_123", true);
        Car car3 = new Car("Bolero", "ABC F_123", true);

        Bike bike1 = new Bike("Honda", "KA53CJ0282", true);

        CarInventory carInventory = new CarInventory("INV_123");
        carInventory.addVehicle(car1);
        carInventory.addVehicle(car3);
        carInventory.addVehicle(car2);

        BikeInventory bikeInventory = new BikeInventory("INV_234");
        bikeInventory.addVehicle(bike1);

        Location location = new Location("Main Road", "560074", "23", "Howrah", "Kerala", "India", 23.55354354, 81.434343);
        Store store = new Store("Ma_FC", "STR_123", location);
        store.addInventory(carInventory);
        store.addInventory(bikeInventory);
        User user = new User("DS", "ADSI2324", "123");

        CarRentalService carRentalService = new CarRentalService(List.of(store));
        Car car = (Car) store.getAllAvailableVehicles(VehicleType.CAR).stream().findFirst().orElse(null);
        if (car != null) {
            carRentalService.orchestrateBooking(user.getUserId(), store.getStoreId(), car.getVehicleNo(), VehicleType.CAR);
        }
    }
}