package com.maksim.domain;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

/**
 * Created by User on 05/04/2018.
 */
public class Payment {
    private int paymentId;
    private int userId;
    private BigDecimal price;
    private Date date;
    private Period period;
}
