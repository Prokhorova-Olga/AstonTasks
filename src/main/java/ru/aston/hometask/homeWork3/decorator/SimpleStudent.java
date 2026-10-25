package ru.aston.hometask.homeWork3.decorator;

public class SimpleStudent implements Student {

    private final String group;
    private final double averageGrade;
    private final String recordBook;
    private final String status;

    public SimpleStudent(String group, double averageGrade, String recordBook, String status) {
        this.group = group;
        this.averageGrade = averageGrade;
        this.recordBook = recordBook;
        this.status = status;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getRecordBook() {
        return recordBook;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
