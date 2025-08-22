package ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SocialMediaApp {
    private ConcurrentHashMap<String, Integer> followerCounts;

    public SocialMediaApp(){
        followerCounts = new ConcurrentHashMap<>();
    }

    public void addFollower(String username){
        followerCounts.put(username, 0);
    }

    public void incrementFollowerCount(String username){
        followerCounts.computeIfPresent(username, (key, value)->value+1);
    }

    public int getFollowerCount(String username){
        return followerCounts.getOrDefault(username, 0);
    }
}
