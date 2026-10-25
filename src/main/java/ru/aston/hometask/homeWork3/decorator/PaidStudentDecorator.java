package ru.aston.hometask.homeWork3.decorator;

public class PaidStudentDecorator extends StudentDecorator {

    public PaidStudentDecorator(Student wrappedStudent) {
        super(wrappedStudent);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " Учится на платной основе";
    }
}
