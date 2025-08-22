package org.example;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Executor executor = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for(int i=0; i<5; i++){
            FleetBookingSystem bookingSystem = new FleetBookingSystem(4, true);
            FleetBookingSystem cancellationSystem = new FleetBookingSystem(4, false);

            executorService.submit(bookingSystem);
            executorService.submit(cancellationSystem);
        }

        executorService.shutdown();

        // wait for all tasks to compete or timeout
        if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Terminating tasks forcefully!");
            // if the timeout is reached, forcefully terminate the tasks
            executorService.shutdownNow();

            // wait for all tasks to be forcefully terminated
            if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                System.err.println("Executor did not terminate!");
            }
        }

        System.out.println("All tasks completed!");

    }
}