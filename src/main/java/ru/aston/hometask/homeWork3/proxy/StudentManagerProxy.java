package ru.aston.hometask.homeWork3.proxy;

import ru.aston.hometask.homeWork3.builder.Student;

public class StudentManagerProxy implements StudentManager {

    private final StudentManager realStudentManager;
    private final String roleUser;
    private static final String ADMIN = "ADMIN";

    public StudentManagerProxy(StudentManager realStudentManager, String roleUser) {
        this.realStudentManager = realStudentManager;
        this.roleUser = roleUser;
    }

    @Override
    public void addStudent(Student student) {
        if (ADMIN.equals(roleUser)) {
            realStudentManager.addStudent(student);
        } else {
            System.out.println("Недостаточно прав доступа");
        }
    }

    @Override
    public void deleteStudent(String recordBook) {
        if (ADMIN.equals(roleUser)) {
            realStudentManager.deleteStudent(recordBook);
        } else {
            System.out.println("Недостаточно прав доступа");
        }
    }
}
