package ru.aston.hometask.homeWork3.decorator;

public class BudgetStudentDecorator extends StudentDecorator {

    public BudgetStudentDecorator(Student wrappedStudent) {
        super(wrappedStudent);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " Учится на бюджете";
    }
}
