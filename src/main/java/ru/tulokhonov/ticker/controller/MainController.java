package ru.tulokhonov.ticker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tulokhonov.ticker.Utils;
import ru.tulokhonov.ticker.model.Ticker;
import ru.tulokhonov.ticker.repository.TickerRepository;

import java.util.List;

@RestController
public class MainController {
    private final TickerRepository tickerRepository;

    public MainController(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    @GetMapping("/all")
    public List<Ticker> all() {
        return tickerRepository.findAll();
    }

    @GetMapping("/search")
    public List<Ticker> search(@RequestParam String by, @RequestParam String value) {
        switch (by) {
            case "datePay": return tickerRepository.findByDatePay(value);
            case "amount": return tickerRepository.findByAmount(value);
            case "dateEx": return tickerRepository.findByDateEx(value);
            case "ticker" : return tickerRepository.findByTicker(value);
        }
        throw new IllegalArgumentException("Неверный параметр \"by\"");
    }
}
