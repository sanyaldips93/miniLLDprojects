import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Slot> floor1Slots = Arrays.asList(
                new CarSlot(1), new CarSlot(2)
        );
        List<Slot> floor2Slots = Arrays.asList(
                new CarSlot(3), new CarSlot(4)
        );
        Floor floor1 = new Floor(1, floor1Slots);
        Floor floor2 = new Floor(2, floor2Slots);

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(floor1, floor2), new FirstAvailableSlotStrategy(), new HourlyFeeStrategy(4));
        Vehicle car1 = new Vehicle(VehicleType.CAR, "KA-53-CJ-0828");
        Vehicle car2 = new Vehicle(VehicleType.CAR, "KA-53-CJ-0829");

        Vehicle bike1 = new Vehicle(VehicleType.BIKE, "KA-54-CJ-0829");
        Vehicle bike2 = new Vehicle(VehicleType.BIKE, "KA-54-CJ-0729");

        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(car2);
        Ticket ticket3 = parkingLot.parkVehicle(bike1);
        Ticket ticket4 = parkingLot.parkVehicle(bike2);

        double amount1 = parkingLot.unparkVehicle(ticket1);
        double amount2 = parkingLot.unparkVehicle(ticket2);
        double amount3 = parkingLot.unparkVehicle(ticket3);
        double amount4 = parkingLot.unparkVehicle(ticket4);
    }
}