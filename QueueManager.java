import java.util.ArrayList;
import java.util.List;

public class QueueManager implements QueueSubject {
    private final List<QueueObserver> observers = new ArrayList<>();
    private int currentQueueNumber = 0;
    private int nextTicketNumber = 1;

    @Override
    public void registerObserver(QueueObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(QueueObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (QueueObserver observer : observers) {
            observer.update(currentQueueNumber);
        }
    }

    public synchronized int issueTicket() {
        int ticket = nextTicketNumber++;
        System.out.println("[System] New ticket issued to visitor: Queue #" + ticket);
        return ticket;
    }

    public synchronized void callNext(int stationId) {
        currentQueueNumber++;
        System.out.println("\n[Station " + stationId + "] Now serving Queue Number: " + currentQueueNumber);
        notifyObservers();
    }

    public synchronized void resetQueue(int newNumber, int stationId) {
        System.out.println("\n[Alert - Station " + stationId + "] Queue number manually reset from " 
                           + currentQueueNumber + " to " + newNumber);
        currentQueueNumber = newNumber;
        nextTicketNumber = Math.max(nextTicketNumber, newNumber + 1);
        notifyObservers();
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }
}