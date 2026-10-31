package ru.aston.hometask.homeWork3.proxy;

import ru.aston.hometask.homeWork3.builder.Student;

import java.util.ArrayList;
import java.util.List;

public class RealStudentManager implements StudentManager {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Студент " + student + " успешно добавлен");
    }

    @Override
    public void deleteStudent(String recordBook) {
        boolean isDeleted = students.removeIf(student -> student.getRecordBook().equals(recordBook));
        if (isDeleted) {
            System.out.println("Студент с номером зачетной книжки: " + recordBook + " успешно удален");
        } else {
            System.out.println("Студент с номером зачетной книжки: " + recordBook + " не найден");
        }
    }
}
