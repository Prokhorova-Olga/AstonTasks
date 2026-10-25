package ru.aston.hometask.homeWork3.chainOfResponsibility;

import ru.aston.hometask.homeWork3.builder.Student;

public class AverageGradeValidator extends AbstractStudentValidator {

    @Override
    public boolean validate(Student student) {
        if (student.getAverageGrade() < 1 || student.getAverageGrade() > 5) {
            System.out.println("Недопустимое значение: Средний балл должен быть от 0 до 5");
            return false;
        }
        return super.validate(student);
    }
}
