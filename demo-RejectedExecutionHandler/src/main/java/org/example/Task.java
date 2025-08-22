package org.example;

public class Task implements Runnable{
    private int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("Task " + taskId + " is being executed.");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
