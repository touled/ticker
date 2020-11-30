package ru.tulokhonov.ticker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ticker {
    private final String ticker;
    private final LocalDate datePay;
    private final BigDecimal amount;
    private final LocalDate dateEx;

    public Ticker(String ticker, LocalDate datePay, BigDecimal amount, LocalDate dateEx) {
        this.ticker = ticker;
        this.datePay = datePay;
        this.amount = amount;
        this.dateEx = dateEx;
    }

    public String getTicker() {
        return ticker;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDateEx() {
        return dateEx;
    }
}
