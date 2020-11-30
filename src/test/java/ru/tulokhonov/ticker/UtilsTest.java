package ru.tulokhonov.ticker;

import org.junit.jupiter.api.Test;
import ru.tulokhonov.ticker.model.Ticker;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void givenCsv_whenParse_thenOk() {
        File file = new File("./src/test/resources/div.csv");
        assertTrue(file.exists());
        List<Ticker> result = Utils.parseCsv(file);
        assertEquals(16, result.size());
        assertEquals("JNJ", result.get(8).getTicker());
        assertEquals(new BigDecimal("0.25"), result.get(14).getAmount());
    }
}