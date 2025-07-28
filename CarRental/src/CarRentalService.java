import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarRentalService {
    private final List<Store> storeList;
    private User user;

    public CarRentalService(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Booking orchestrateBooking(String userId, String storeId, String vehicleId, VehicleType vehicleType) {
        Double fixedAmount = 50.00;
        Store store = (Store) this.storeList.stream().
                filter(inv -> Objects.equals(inv.getStoreId(), storeId)).findFirst().orElse(null);
        VehicleInventory vehicleInventory = null;
        Vehicle vehicle = null;
        if (store != null) {
            vehicleInventory = (VehicleInventory) (store.getVehicleInventoryList().stream().
                    filter(inv -> inv.getVehicleType() == vehicleType).findFirst().orElse(null));
            if (vehicleInventory != null) {
                vehicle = vehicleInventory.getAvailableVehicleList().stream()
                        .filter(inv -> inv.getVehicleNo().equals(vehicleId))
                        .findFirst()
                        .orElse(null);
            }
        }
        if (vehicle != null) {
            Booking booking = new Booking(storeId, vehicle, userId, fixedAmount);
            Payment payment = booking.makePayment();
            System.out.println("Booking done for : userId = " + userId + ", storeId = " + storeId + ", vehicleId = " + vehicleId + ", vehicleType = " + vehicleType);
            System.out.println("Booking id: " + booking.getBookingId());
            System.out.println("Payment id: " + payment.getPaymentId());
            return booking;
        }
        return null;
    }
}
