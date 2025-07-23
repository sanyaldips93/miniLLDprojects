import java.util.List;

public class NearestScheduler implements CarScheduler {
    @Override
    public ElevatorCar selectCar(List<ElevatorCar> elevatorCars, Request req) {
        ElevatorCar bestCar = null;
        int bestScore = Integer.MAX_VALUE;
        for (ElevatorCar elevatorCar: elevatorCars) {
            int score = (elevatorCar.getCurrentFloor() - req.getFloor()) + elevatorCar.getQueueSize();
            if (score < bestScore) {
                bestScore = score;
                bestCar = elevatorCar;
            }
        }
        return bestCar;
    }
}
