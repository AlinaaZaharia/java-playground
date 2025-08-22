package ConcurrentHashMap;

import ConcurrentLinkedQueue.GlobalLogisticsApp;

public class Main {
    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();
        app.addFollower("Alex");
        app.addFollower("Ana");
        app.addFollower("Alina");

        // simulating concurrent follower count increment
        /*Thread thread1 = new Thread(()->app.incrementFollowerCount("Alex"));
        Thread thread2 = new Thread(()->app.incrementFollowerCount("Alex"));

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }*/

        int alexFollowerCount = app.getFollowerCount("Alex");
        //System.out.println("Alex's follower count: " + alexFollowerCount);

        // concurrent read operation
        Thread readThread = new Thread(() -> {
            System.out.println("Alex's follower count (read Thread): " + alexFollowerCount);
        });

        // concurrent write operation
        Thread writeThread = new Thread(() -> {
            app.incrementFollowerCount("Alex");
            System.out.println("Incremented Alex's follower count.");
        });

        readThread.start();
        writeThread.start();

        try{
            readThread.join();
            writeThread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
