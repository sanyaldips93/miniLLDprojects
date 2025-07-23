//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(3, new NearestScheduler());
        system.hallButtonPressed(5, Direction.UP);
        system.hallButtonPressed(7, Direction.UP);
        system.hallButtonPressed(3, Direction.DOWN);
        system.hallButtonPressed(1, Direction.DOWN);
        system.carButtonPressed(6, 5);
        system.step();
    }
}