package com.maksim.model.dao;

import com.maksim.domain.Payment;
import com.maksim.domain.Publication;
import com.maksim.domain.Subscription;
import com.maksim.domain.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Максим on 30/Apr/18.
 */
public interface PaymentDAO {
    boolean addPayment(User user, List<Publication> publicationList,BigDecimal totalPrice) throws SQLException;

    Payment findPaymentById(int paymentId);

    void deletePayment(Payment payment);
}
