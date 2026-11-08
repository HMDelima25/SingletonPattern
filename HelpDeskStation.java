public class HelpDeskStation {
    private final int stationId;
    private final QueueManager queueManager;

    public HelpDeskStation(int stationId, QueueManager queueManager) {
        this.stationId = stationId;
        this.queueManager = queueManager;
    }

    public void serveNext() {
        queueManager.callNext(stationId);
    }

    public void resetQueue(int newNumber) {
        queueManager.resetQueue(newNumber, stationId);
    }

    public int getStationId() {
        return stationId;
    }
}