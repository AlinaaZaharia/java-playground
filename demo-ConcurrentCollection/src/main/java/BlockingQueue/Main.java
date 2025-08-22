package BlockingQueue;

public class Main {
    public static void main(String[] args){
        SocialMediaApp app = new SocialMediaApp();

        app.processPosts();

        Thread user1 = new Thread(() -> app.userPost("User1 posted update 1."));
        Thread user2 = new Thread(() -> app.userPost("User2 posted update 2."));
        Thread user3 = new Thread(() -> app.userPost("User3 posted update 3."));

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
