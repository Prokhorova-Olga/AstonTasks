package ru.aston.hometask.homeWork3.demo;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.strategy.InsertionSort;
import ru.aston.hometask.homeWork3.strategy.MergeSort;
import ru.aston.hometask.homeWork3.strategy.StudentSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuilderAndStrategyDemo {

    public static void main(String[] args) {

        System.out.println("Проверка паттерна Строитель");

        Student studentOne = Student.builder().group("А-1").averageGrade(3.8).recordBook("56789").build();
        Student studentTwo = Student.builder().group("Б-1").averageGrade(3.0).recordBook("76589").build();
        Student studentThree = Student.builder().group("В-1").averageGrade(5.0).recordBook("12389").build();

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
