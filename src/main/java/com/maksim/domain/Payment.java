package com.maksim.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by User on 05/04/2018.
 */
public class Payment {
    private int paymentId;
    private User user;
    private BigDecimal totalPrice;
    private Timestamp dateTime;

    public Payment() {
    }

    public Payment(int paymentId, User user, BigDecimal totalPrice, Timestamp dateTime) {
        this.paymentId = paymentId;
        this.user = user;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (paymentId != payment.paymentId) return false;
        if (!user.equals(payment.user)) return false;
        if (!totalPrice.equals(payment.totalPrice)) return false;
        return dateTime.equals(payment.dateTime);

    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + user.hashCode();
        result = 31 * result + totalPrice.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", userId=" + user +
                ", totalPrice=" + totalPrice +
                ", dateTime=" + dateTime +
                '}';
    }
}
