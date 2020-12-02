package ru.tulokhonov.ticker.repository;

import ru.tulokhonov.ticker.model.Ticker;
import java.util.List;

public interface TickerRepository {
    /**
     * Ищет все тикеры в репозитории
     * @return все тикеры в репозитории
     */
    List<Ticker> findAll();

    /**
     * Ищет тикеры по полю ticker
     * @param ticker искомое значение
     * @return все тикеры, в которых поле ticker совпадает с параметром ticker
     */
    List<Ticker> findByTicker(String ticker);

    /**
     * Ищет тикеры по полю datePay
     * @param datePay искомое значение
     * @return все тикеры, в которых поле datePay совпадает с параметром datePay
     */
    List<Ticker> findByDatePay(String datePay);

    /**
     * Ищет тикеры по полю dateEx
     * @param dateEx искомое значение
     * @return все тикеры, в которых поле dateEx совпадает с параметром dateEx
     */
    List<Ticker> findByDateEx(String dateEx);

    /**
     * Ищет тикеры по полю amount
     * @param amount искомое значение
     * @return все тикеры, в которых поле amount совпадает с параметром amount
     */
    List<Ticker> findByAmount(String amount);
}