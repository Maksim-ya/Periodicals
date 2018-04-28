package com.maksim.model.dao;

import com.maksim.domain.Subscription;

import java.util.List;

public interface SubscriptionDAO {

    List<Subscription> findSubscriptionsByUser(int userId);
    boolean addSubscription(Subscription subscription);
}
