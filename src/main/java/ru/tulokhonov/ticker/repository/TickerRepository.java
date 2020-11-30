package ru.tulokhonov.ticker.repository;

import ru.tulokhonov.ticker.model.Ticker;
import java.util.List;

public interface TickerRepository {
    List<Ticker> findAll();

    List<Ticker> findByTicker(String ticker);

    List<Ticker> findByDatePay(String datePay);

    List<Ticker> findByDateEx(String dateEx);

    List<Ticker> findByAmount(String amount);
}