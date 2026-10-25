package ru.aston.hometask.homeWork3.decorator;

abstract class StudentDecorator implements Student {
    protected Student wrappedStudent;

    public StudentDecorator(Student wrappedStudent) {
        this.wrappedStudent = wrappedStudent;
    }

    @Override
    public String getGroup() {
        return wrappedStudent.getGroup();
    }

    @Override
    public double getAverageGrade() {
        return wrappedStudent.getAverageGrade();
    }

    @Override
    public String getRecordBook() {
        return wrappedStudent.getRecordBook();
    }

    @Override
    public String getStatus() {
        return wrappedStudent.getStatus();
    }
}
