package ru.edu.hse;


import java.util.ArrayList;
import java.util.List;

public class GameBlog implements IBlog {
    private String post;
    private List<ISubscriber> subscribers;

    public GameBlog() {
        subscribers = new ArrayList<ISubscriber>();
    }

    public void setPost(String post) {
        this.post = post;
        notifySubscribers();
    }

    public void addSubscriber(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void deleteSubscriber(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (ISubscriber subscriber: subscribers) {
            subscriber.update(post);
        }
    }
}
