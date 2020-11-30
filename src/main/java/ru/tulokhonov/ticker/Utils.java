package ru.tulokhonov.ticker;

import ru.tulokhonov.ticker.model.Ticker;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Utils {
    private static final String SEMICOLON_DELIMITER = ";";
    private static final int COLUMNS = 4;

    public static List<Ticker> parseCsv(File file) {
        List<Ticker> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine())
                        .orElseThrow(
                            () -> new IllegalArgumentException("Invalid values. Please check CSV file")
                        ));
            }
        } catch (FileNotFoundException exception) {
            throw new IllegalStateException("File not found!", exception);
        }
        return records;
    }

    private static Optional<Ticker> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(SEMICOLON_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        if (values.size() == COLUMNS) {
            return Optional.of(new Ticker(
                    values.get(0),
                    LocalDate.parse(values.get(1)),
                    new BigDecimal(values.get(2)),
                    LocalDate.parse(values.get(3))
            ));
        }
        return Optional.empty();
    }
}


