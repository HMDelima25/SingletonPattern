public class Main {
    public static void main(String[] args) {
        // Initialize Centralized Queuing System Hub
        QueueManager centralSystem = new QueueManager();

        // Setup Online Monitoring Displays (Observers)
        QueueObserver webMonitor = new OnlineMonitor("Web Portal");
        QueueObserver lobbyDisplay = new OnlineMonitor("Main Lobby TV Screen");

        centralSystem.registerObserver(webMonitor);
        centralSystem.registerObserver(lobbyDisplay);

        // Setup 3 Help Desk Stations
        HelpDeskStation station1 = new HelpDeskStation(1, centralSystem);
        HelpDeskStation station2 = new HelpDeskStation(2, centralSystem);
        HelpDeskStation station3 = new HelpDeskStation(3, centralSystem);

        System.out.println("=== Phase 1: Visitors Obtaining Queue Tickets ===");
        centralSystem.issueTicket(); // #1
        centralSystem.issueTicket(); // #2
        centralSystem.issueTicket(); // #3
        centralSystem.issueTicket(); // #4

        System.out.println("\n=== Phase 2: Help Desk Stations Processing Queue ===");
        station1.serveNext(); // Calls Queue #1
        station2.serveNext(); // Calls Queue #2

        System.out.println("\n=== Phase 3: Handling Technical Reset / Reorganization at Station 3 ===");
        // Due to technical error or workflow reset, station 3 resets the active queue number
        station3.resetQueue(10); 

        System.out.println("\n=== Phase 4: Resuming Normal Queue Operations Post-Reset ===");
        centralSystem.issueTicket(); // #11
        station3.serveNext(); // Calls Queue #11
    }
}