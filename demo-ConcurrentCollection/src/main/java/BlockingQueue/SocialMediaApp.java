package BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SocialMediaApp {
    private BlockingQueue<String> postsQueue;

    public SocialMediaApp(){
        // init the blocking queue with a max capacity
        postsQueue = new LinkedBlockingQueue<>(10);
    }

    public void userPost(String post){
        try{
            // enqueue the post using the put() method
            postsQueue.put(post);
            System.out.println("User posted: " + post);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void processPosts(){
        Thread processingThread = new Thread(() -> {
            while(true){
                try{
                    // dequeue the post using the take() method (will block if queue is empty)
                    String post = postsQueue.take();
                    System.out.println("Processing post: "+ post);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
