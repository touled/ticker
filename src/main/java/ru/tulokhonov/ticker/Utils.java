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
    // разделитель в файле CSV
    private static final String SEMICOLON_DELIMITER = ";";
    // число столбцов в файле CSV
    private static final int COLUMNS = 4;

    /**
     * Построчно считывает файл CSV, используя SEMICOLON_DELIMITER как разделитель
     * @param file - файл CSV
     * @return возвращает список объектов Ticker
     * @throws IllegalArgumentException если файл содержит неверные записи
     * @throws IllegalStateException если не удалось найти файл
     */
    public static List<Ticker> parseCsv(File file) {
        List<Ticker> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine())
                        .orElseThrow(
                            () -> new IllegalArgumentException("Неверный формат данных CSV файла")
                        ));
            }
        } catch (FileNotFoundException exception) {
            throw new IllegalStateException("Файл CSV не найден!", exception);
        }
        return records;
    }

    /**
     * Читает данные со строки и создает объект Ticker
     * @param line - строка, считанная из файла CSV
     * @return возвращает объект Ticker, если удалось считать все данные для создания объекта, иначе возвращает пустой опциоанльный объект
     */
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


