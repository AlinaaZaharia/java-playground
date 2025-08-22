package org.example;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 3;
        long keepAliveTime = 60;
        int queueCapacity = 1;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity));

        // set a custom RejectedExecutionHandler to handle rejected tasks
        executor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());

        for(int i=1; i<=5; i++){
            Task task = new Task(i);
            executor.submit(task);
        }
        executor.shutdown();
    }
}