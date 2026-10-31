package ru.aston.hometask.homeWork3.chainOfResponsibility;

import ru.aston.hometask.homeWork3.builder.Student;

public interface StudentValidator {

    void setNext(StudentValidator next);

    boolean validate(Student student);
}
