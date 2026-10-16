package ru.aston.hometask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("students.json")) {
            if (inputStream == null) {
                System.out.println("Файл не найден");
                return;
            }
            List<Student> students = objectMapper.readValue(inputStream, new TypeReference<List<Student>>() {
            });
            students.stream()
                    .peek(student -> System.out.println("Информация о студенте " + student))
                    .map(Student::getBooks)
                    .flatMap(List::stream)
                    .sorted(Comparator.comparingInt(Book::getPage))
                    .distinct()
                    .filter(book -> book.getYear() > 2000)
                    .limit(3)
                    .map(Book::getYear)
                    .findFirst()
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Книга не найдена"));
        } catch (JsonProcessingException e) {
            System.out.println("JSON поврежден или не соответствует структуре");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}