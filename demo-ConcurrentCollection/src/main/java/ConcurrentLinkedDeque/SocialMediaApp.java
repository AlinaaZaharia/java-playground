package ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SocialMediaApp {
    private ConcurrentLinkedDeque<String> commentsDeque;

    public SocialMediaApp(){
        commentsDeque = new ConcurrentLinkedDeque<>();
    }

    public void addComment(String comment){
        commentsDeque.add(comment);
    }

    public void processComments(){
        Thread processThread = new Thread(() -> {
            while(true){
                if(!commentsDeque.isEmpty()){
                    String comment = commentsDeque.pollFirst();
                    processComment(comment);
                }
            }
        });
        processThread.start();
    }

    public void processComment(String comment){
        // simulate processing the comment
        System.out.println("Processing comment " + comment);
    }
}
