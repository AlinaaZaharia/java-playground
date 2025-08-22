package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Future<String> bookingFuture;
        Future<String> cancellationFuture;

        for(int i=0; i<5; i++){
            FleetBookingSystem bookingSystem = new FleetBookingSystem(4, true);
            FleetBookingSystem cancellationSystem = new FleetBookingSystem(4, false);

            bookingFuture = executorService.submit(bookingSystem);
            cancellationFuture = executorService.submit(cancellationSystem);

            System.out.println(bookingFuture.get());
            System.out.println(cancellationFuture.get());
        }

        executorService.shutdown();

        // wait for all tasks to compete or timeout
        /*if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
            System.out.println("Terminating tasks forcefully!");
            // if the timeout is reached, forcefully terminate the tasks
            executorService.shutdownNow();

            // wait for all tasks to be forcefully terminated
            if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                System.err.println("Executor did not terminate!");
            }
        }

        System.out.println("All tasks completed!");*/

    }
}