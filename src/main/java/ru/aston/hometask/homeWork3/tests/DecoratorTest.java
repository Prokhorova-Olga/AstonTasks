package ru.aston.hometask.homeWork3.tests;

import ru.aston.hometask.homeWork3.decorator.BudgetStudentDecorator;
import ru.aston.hometask.homeWork3.decorator.PaidStudentDecorator;
import ru.aston.hometask.homeWork3.decorator.SimpleStudent;
import ru.aston.hometask.homeWork3.decorator.Student;

public class DecoratorTest {

    public static void main(String[] args) {

        Student student = new SimpleStudent("A-1", 4.5, "12345", "Обычный студент");
        System.out.println("Обычный студент: " + student.getStatus());

        Student budgetStudent = new BudgetStudentDecorator(student);
        System.out.println("После декоратора BudgetStudentDecorator: " + budgetStudent.getStatus());

        Student paidStudent = new PaidStudentDecorator(budgetStudent);
        System.out.println("budgetStudent после декоратора PaidStudentDecorator(двойной статус): " + paidStudent.getStatus());
    }
}
