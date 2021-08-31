# Ticker

Пример простого REST API для получения данных из файла CSV.

## Требования

- Java 1.8+
- Скачайте репозиторий и выполните `./mvnw spring-boot:run`

## Использование

Пример фильтрации данных по параметру и значению:

`$ curl -X GET "http://localhost:8080/search?by=amount&value=0.09"`

Пример вывода всех данных:

`$ curl -X GET "http://localhost:8080/all"`

Test branch
New Test info 2