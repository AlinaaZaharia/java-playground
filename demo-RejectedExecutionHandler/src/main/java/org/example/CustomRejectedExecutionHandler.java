package org.example;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
        System.out.println("Task rejected. Handling the rejected task in a custom way!");
        // perform custom handling, such as logging or re-queueing the task
    }
}
