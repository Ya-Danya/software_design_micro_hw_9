package ru.edu.hse;

public interface IBlog {
    void addSubscriber(ISubscriber subscriber);
    void deleteSubscriber(ISubscriber subscriber);
    void notifySubscribers();
}
