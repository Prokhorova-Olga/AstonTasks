package ru.aston.hometask.homeWork3.strategy;

import ru.aston.hometask.homeWork3.builder.Student;

import java.util.Comparator;
import java.util.List;

public class StudentSorter {

    private SortStrategy sortStrategy;

    public StudentSorter(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void executeSort(List<Student> students, Comparator<Student> comparator) {
        if (sortStrategy == null) {
            System.out.println("Стратегия не выбрана");
            return;
        }
        sortStrategy.sort(students, comparator);
    }
}
