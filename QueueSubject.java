public interface QueueSubject {
    void registerObserver(QueueObserver observer);
    void removeObserver(QueueObserver observer);
    void notifyObservers();
}