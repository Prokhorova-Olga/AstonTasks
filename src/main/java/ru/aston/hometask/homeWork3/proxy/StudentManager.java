package ru.aston.hometask.homeWork3.proxy;

import ru.aston.hometask.homeWork3.builder.Student;

public interface StudentManager {

    void addStudent(Student student);

    void deleteStudent(String recordBook);
}
