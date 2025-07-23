import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private final List<ElevatorCar> elevatorCars;
    private final CarScheduler carScheduler;

    public ElevatorSystem(int elevatorCarCount, CarScheduler carScheduler) {
        this.carScheduler = carScheduler;
        this.elevatorCars =  new ArrayList<>();
        for (int i = 0; i < elevatorCarCount; i++) {
            elevatorCars.add(new ElevatorCar(i));
        }
    }

    public void hallButtonPressed(int floor, Direction dir) {
        Request request = new Request(floor);
        ElevatorCar elevatorCar = this.carScheduler.selectCar(this.elevatorCars, request);
        elevatorCar.addRequest(request);
    }

    public void carButtonPressed(int carId, int floor) {
        elevatorCars.get(carId).addRequest(new Request(floor));
    }

    public void step() {
        while(elevatorCars.stream().anyMatch(c -> !c.isIdle())) {
            elevatorCars.forEach(elevatorCar -> elevatorCar.step());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }
    }
}
