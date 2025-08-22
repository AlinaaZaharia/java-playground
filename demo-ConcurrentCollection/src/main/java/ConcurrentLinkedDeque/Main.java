package ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args){
        SocialMediaApp app = new SocialMediaApp();

        // start the commenting processing thread
        app.processComments();

        // simulate multiple users adding comments concurrently
        Thread user1 = new Thread(() -> app.addComment("User1 commented on post 1."));
        Thread user2 = new Thread(() -> app.addComment("User2 commented on post 1."));
        Thread user3 = new Thread(() -> app.addComment("User3 commented on post 2."));

        user1.start();
        user2.start();
        user3.start();

        try{
            user1.join();
            user2.join();
            user3.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
