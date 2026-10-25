package ru.aston.hometask.homeWork3.builder;

import java.util.Objects;

public class Student {
    private final String group;
    private final double averageGrade;
    private final String recordBook;

    Student(String group, double averageGrade, String recordBook) {
        this.group = group;
        this.averageGrade = averageGrade;
        this.recordBook = recordBook;
    }

    public String getGroup() {
        return group;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getRecordBook() {
        return recordBook;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(averageGrade, student.averageGrade) == 0 && Objects.equals(group, student.group) && Objects.equals(recordBook, student.recordBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, averageGrade, recordBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", averageGrade=" + averageGrade +
                ", recordBook='" + recordBook + '\'' +
                '}';
    }
}
