public class OnlineMonitor implements QueueObserver {
    private final String location;

    public OnlineMonitor(String location) {
        this.location = location;
    }

    @Override
    public void update(int currentQueueNumber) {
        System.out.println("[Online Monitor (" + location + ")] Real-time Display Update -> Currently Serving: Queue #" + currentQueueNumber);
    }
}