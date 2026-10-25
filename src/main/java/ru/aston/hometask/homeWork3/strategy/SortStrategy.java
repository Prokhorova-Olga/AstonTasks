package ru.aston.hometask.homeWork3.strategy;

import ru.aston.hometask.homeWork3.builder.Student;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy {

    void sort(List<Student> studentList, Comparator<Student> comparator);
}
