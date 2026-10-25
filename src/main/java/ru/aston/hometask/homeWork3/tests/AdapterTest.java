package ru.aston.hometask.homeWork3.tests;

import ru.aston.hometask.homeWork3.adapter.JsonStudentAdapter;
import ru.aston.hometask.homeWork3.adapter.StudentProvider;
import ru.aston.hometask.homeWork3.builder.Student;

import java.io.IOException;
import java.util.List;

public class AdapterTest {

    public static void main(String[] args) {

        StudentProvider studentProvider = new JsonStudentAdapter();

        try {
            List<Student> students = studentProvider.read();
            System.out.println("Адаптер успешно прочитал JSON и вернул студентов: ");
            students.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
