package com.maksim.model.dao;

import com.maksim.domain.Payment;
import com.maksim.domain.Publication;
import com.maksim.domain.Subscription;
import com.maksim.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Максим on 30/Apr/18.
 */
public interface PaymentDAO {
    boolean addPayment(Payment payment, User user, List<Publication> publicationList) throws SQLException;

    Payment findPaymentById(int paymentId);
}
