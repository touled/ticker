package ru.tulokhonov.ticker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tulokhonov.ticker.Utils;
import ru.tulokhonov.ticker.model.Ticker;
import javax.annotation.PostConstruct;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class TickerRepositoryImpl implements TickerRepository {
    @Autowired
    private File file;

    @Override
    public List<Ticker> findAll() {
        return Utils.parseCsv(file);
    }

    @Override
    public List<Ticker> findByTicker(String ticker) {
        return findAll()
                .stream()
                .filter(t -> t.getTicker().equals(ticker))
                .collect(toList());
    }

    @Override
    public List<Ticker> findByDatePay(String datePay) {
        LocalDate target = LocalDate.parse(datePay);
        return findAll()
                .stream()
                .filter(t -> t.getDatePay().equals(target))
                .collect(toList());
    }

    @Override
    public List<Ticker> findByDateEx(String dateEx) {
        LocalDate target = LocalDate.parse(dateEx);
        return findAll()
                .stream()
                .filter(t -> t.getDateEx().equals(target))
                .collect(toList());
    }

    @Override
    public List<Ticker> findByAmount(String amount) {
        BigDecimal target = new BigDecimal(amount);
        return findAll()
                .stream()
                .filter(t -> t.getAmount().equals(target))
                .collect(toList());
    }

    /**
     * Проверяет файл на присутствие. Предотвращает запуск приложения при отсутствии файла
     * @throws IllegalStateException если файл не существует
     */
    @PostConstruct
    public void setup() {
        if (!file.exists()) throw new IllegalArgumentException("Файл CSV не найдет");
    }
}
