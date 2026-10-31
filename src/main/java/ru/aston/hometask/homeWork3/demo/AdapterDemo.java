package ru.aston.hometask.homeWork3.demo;

import ru.aston.hometask.homeWork3.adapter.JsonFileReader;
import ru.aston.hometask.homeWork3.adapter.JsonStudentAdapter;
import ru.aston.hometask.homeWork3.adapter.StudentProvider;
import ru.aston.hometask.homeWork3.builder.Student;

import java.io.IOException;
import java.util.List;

public class AdapterDemo {

    public static void main(String[] args) {

        JsonFileReader jsonFileReader = new JsonFileReader();
        StudentProvider studentProvider = new JsonStudentAdapter(jsonFileReader);

        try {
            List<Student> students = studentProvider.read();
            System.out.println("Адаптер успешно прочитал JSON и вернул студентов: ");
            students.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
