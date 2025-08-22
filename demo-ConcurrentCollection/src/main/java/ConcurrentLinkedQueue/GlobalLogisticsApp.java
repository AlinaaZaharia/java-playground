package ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class GlobalLogisticsApp {
    private ConcurrentLinkedQueue<String> requests;

    public GlobalLogisticsApp(){
        requests = new ConcurrentLinkedQueue<>();
    }

    public void addRequest(String request){
        requests.add(request);
    }

    public void processRequests(){
        requests.parallelStream().forEach(this::processRequest);
    }

    public void processRequest(String request){
        // simulate processing the request
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Proessed request: " + request);
    }
}

