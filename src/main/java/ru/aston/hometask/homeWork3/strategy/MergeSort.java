package ru.aston.hometask.homeWork3.strategy;

import ru.aston.hometask.homeWork3.builder.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements SortStrategy {

    private void merge(List<Student> studentList, List<Student> leftPart, List<Student> rightPart, Comparator<Student> comparator) {

        int leftElement = 0;
        int rightElement = 0;
        int mainPart = 0;

        while (leftElement < leftPart.size() && rightElement < rightPart.size()) {
            if (comparator.compare(leftPart.get(leftElement), rightPart.get(rightElement)) <= 0) {
                studentList.set(mainPart, leftPart.get(leftElement));
                leftElement++;
            } else {
                studentList.set(mainPart, rightPart.get(rightElement));
                rightElement++;
            }
            mainPart++;
        }
        while (leftElement < leftPart.size()) {
            studentList.set(mainPart, leftPart.get(leftElement));
            leftElement++;
            mainPart++;
        }

        while (rightElement < rightPart.size()) {
            studentList.set(mainPart, rightPart.get(rightElement));
            rightElement++;
            mainPart++;
        }
    }

    @Override
    public void sort(List<Student> studentList, Comparator<Student> comparator) {
        if (studentList.size() < 2) {
            return;
        }
        int middle = studentList.size() / 2;

        List<Student> left = new ArrayList<>(studentList.subList(0, middle));
        List<Student> right = new ArrayList<>(studentList.subList(middle, studentList.size()));

        sort(left, comparator);
        sort(right, comparator);

        merge(studentList, left, right, comparator);
    }
}
