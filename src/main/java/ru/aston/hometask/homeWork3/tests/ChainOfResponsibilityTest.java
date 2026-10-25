package ru.aston.hometask.homeWork3.tests;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.builder.StudentBuilder;
import ru.aston.hometask.homeWork3.chainOfResponsibility.AverageGradeValidator;
import ru.aston.hometask.homeWork3.chainOfResponsibility.GroupValidator;
import ru.aston.hometask.homeWork3.chainOfResponsibility.RecordBookValidator;
import ru.aston.hometask.homeWork3.chainOfResponsibility.StudentValidator;

public class ChainOfResponsibilityTest {

    public static void main(String[] args) {

        StudentValidator groupValidator = new GroupValidator();
        StudentValidator averageGradeValidator = new AverageGradeValidator();
        StudentValidator recordBookValidator = new RecordBookValidator();

        groupValidator.setNext(averageGradeValidator);
        averageGradeValidator.setNext(recordBookValidator);

        System.out.println("Проверка студента с завышенным баллом");
        Student inflatedAssessmentStudent = new StudentBuilder().setGroup("А-1").setAverageGrade(10).setRecordBook("12345").build();
        boolean inflatedResult = groupValidator.validate(inflatedAssessmentStudent);
        System.out.println("Результат проверки: " + inflatedResult);

        System.out.println("Проверка студента с заниженным баллом");
        Student understatedAssessmentStudent = new StudentBuilder().setGroup("А-1").setAverageGrade(0).setRecordBook("12345").build();
        boolean understatedResult = groupValidator.validate(understatedAssessmentStudent);
        System.out.println("Результат проверки: " + understatedResult);

        System.out.println("Проверка студента с нормальным баллом");
        Student normalAssessmentStudent = new StudentBuilder().setGroup("А-1").setAverageGrade(4.5).setRecordBook("12345").build();
        boolean normalResult = groupValidator.validate(normalAssessmentStudent);
        System.out.println("Результат проверки: " + normalResult);
    }
}
