package ru.tulokhonov.ticker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tulokhonov.ticker.Utils;
import ru.tulokhonov.ticker.repository.TickerRepository;
import ru.tulokhonov.ticker.repository.TickerRepositoryImpl;

import java.io.File;

@Configuration
public class WebConfig {
    @Bean
    public TickerRepository tickerRepository() {
        return new TickerRepositoryImpl();
    }

    @Bean
    public File file() {
        File file = new File("./src/test/resources/div.csv");
        assert file.exists();
        return file;
    }
}
