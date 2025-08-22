package ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        GlobalLogisticsApp app = new GlobalLogisticsApp();
        app.addRequest("Request 1");
        app.addRequest("Request 2");
        app.addRequest("Request 3");
        app.addRequest("Request 4");
        app.addRequest("Request 5");

        app.processRequests();
    }
}
