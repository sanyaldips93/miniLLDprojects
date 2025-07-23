import java.util.*;

public class ElevatorCar {
    private final int id;
    private int currentFloor = 0;
    private final Queue<Request> queue = new ArrayDeque<>();

    public ElevatorCar(int id) {              // pass id from system
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public boolean isIdle() {
        return queue.isEmpty();
    }


    public void addRequest(Request req) {
        queue.offer(req);
        System.out.printf("Car-%d queued floor %d%n", id, req.getFloor());
    }

    public void step() {
        if (queue.isEmpty()) {
            System.out.printf("Car-%d idle at %d%n", id, currentFloor);
            return;
        }
        int target = queue.peek().getFloor();
        if (currentFloor < target) currentFloor++;
        if (currentFloor > target) currentFloor--;
        System.out.printf("Car-%d moving to %d%n", id, currentFloor);

        if (currentFloor == target) {
            queue.poll();
            System.out.printf("Car-%d doors open at %d%n", id, currentFloor);
        }
    }

    public void run() {
        while (!queue.isEmpty()) {
            step();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {}
        }
    }
}
