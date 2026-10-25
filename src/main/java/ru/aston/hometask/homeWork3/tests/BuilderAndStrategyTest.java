package ru.aston.hometask.homeWork3.tests;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.builder.StudentBuilder;
import ru.aston.hometask.homeWork3.strategy.InsertionSort;
import ru.aston.hometask.homeWork3.strategy.MergeSort;
import ru.aston.hometask.homeWork3.strategy.StudentSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuilderAndStrategyTest {

    public static void main(String[] args) {

        System.out.println("Проверка паттерна Строитель");

        Student studentOne = new StudentBuilder().setGroup("А-1").setAverageGrade(3.8).setRecordBook("56789").build();
        Student studentTwo = new StudentBuilder().setGroup("Б-1").setAverageGrade(3.0).setRecordBook("76589").build();
        Student studentThree = new StudentBuilder().setGroup("В-1").setAverageGrade(5.0).setRecordBook("12389").build();

        List<Student> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);
        students.add(studentThree);

        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);

        System.out.println("Проверка паттерна Стратегия");
        System.out.println("Сортировка вставками по среднему баллу");
        StudentSorter studentSorter = new StudentSorter(new InsertionSort());
        studentSorter.executeSort(students, Comparator.comparingDouble(Student::getAverageGrade));
        students.forEach(System.out::println);

        System.out.println("Сортировка слиянием по группе");
        studentSorter.setSortStrategy(new MergeSort());
        studentSorter.executeSort(students, Comparator.comparing(Student::getGroup));
        students.forEach(System.out::println);
    }
}
