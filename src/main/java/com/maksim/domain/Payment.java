package com.maksim.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by User on 05/04/2018.
 */
public class Payment {
    private int paymentId;
    private Subscription subscriptionId;
    private User userId;
    private BigDecimal totalPrice;
    private Date date;

    public Payment() {
    }

    public Payment(int paymentId, Subscription subscriptionId, User userId, BigDecimal totalPrice, Date date) {
        this.paymentId = paymentId;
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (paymentId != payment.paymentId) return false;
        if (!subscriptionId.equals(payment.subscriptionId)) return false;
        if (!userId.equals(payment.userId)) return false;
        if (!totalPrice.equals(payment.totalPrice)) return false;
        return date.equals(payment.date);

    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + subscriptionId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + totalPrice.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", subscriptionId=" + subscriptionId +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                '}';
    }
}
