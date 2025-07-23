import java.util.List;

public interface CarScheduler {
    ElevatorCar selectCar(List<ElevatorCar> elevatorCars, Request req);
}
