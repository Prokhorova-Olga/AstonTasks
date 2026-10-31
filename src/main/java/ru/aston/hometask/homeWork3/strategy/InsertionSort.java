package ru.aston.hometask.homeWork3.strategy;

import ru.aston.hometask.homeWork3.builder.Student;

import java.util.Comparator;
import java.util.List;

public class InsertionSort implements SortStrategy {
    @Override
    public void sort(List<Student> studentList, Comparator<Student> comparator) {
        for (int i = 1; i < studentList.size(); i++) {
            Student currentStudent = studentList.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(studentList.get(j), currentStudent) > 0) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, currentStudent);
        }
    }
}
