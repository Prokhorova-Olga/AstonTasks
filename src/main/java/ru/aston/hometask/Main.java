package ru.aston.hometask;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.aston.hometask.homeWork2.StudentBookService;
import ru.aston.hometask.homeWork2.StudentReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StudentReader studentReader = new StudentReader();
        try {
            StudentBookService studentBookService = new StudentBookService(studentReader.read());
            studentBookService.printResult();
        } catch (JsonProcessingException e) {
            System.out.println("JSON поврежден или не соответствует структуре");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
