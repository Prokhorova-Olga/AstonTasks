package ru.aston.hometask.homeWork3.chainOfResponsibility;

import ru.aston.hometask.homeWork3.builder.Student;

public abstract class AbstractStudentValidator implements StudentValidator {

    private StudentValidator next;

    @Override
    public boolean validate(Student student) {
        if (next != null) {
            return next.validate(student);
        }
        return true;
    }

    @Override
    public void setNext(StudentValidator next) {
        this.next = next;
    }
}
