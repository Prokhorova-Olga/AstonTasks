package ru.aston.hometask.homeWork3.builder;

public class StudentBuilder {
    private String group;
    private double averageGrade;
    private String recordBook;

    public StudentBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public StudentBuilder setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
        return this;
    }

    public StudentBuilder setRecordBook(String recordBook) {
        this.recordBook = recordBook;
        return this;
    }

    public Student build() {
        return new Student(group, averageGrade, recordBook);
    }
}
