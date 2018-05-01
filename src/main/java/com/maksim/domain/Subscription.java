package com.maksim.domain;

//import java.time.Period;

/**
 * Created by User on 05/04/2018.
 */
public class Subscription {
    private int subscriptionId;
    private Publication publication;
    private User user;
    private Payment payment;
    private boolean isActive;

    public Subscription() {
    }

    public Subscription(int subscriptionId, Publication publication, User user, Payment payment, boolean isActive) {
        this.subscriptionId = subscriptionId;
        this.publication = publication;
        this.user = user;
        this.payment = payment;
        this.isActive = isActive;
    }


    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", publication=" + publication +
                ", user=" + user +
                ", payment=" + payment +
                ", isActive=" + isActive +
                '}';
    }
}
