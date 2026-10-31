package ru.aston.hometask.homeWork3.proxy;

import ru.aston.hometask.homeWork3.builder.Student;

public class StudentManagerProxy implements StudentManager {

    private final StudentManager realStudentManager;
    private final Role roleUser;

    public StudentManagerProxy(StudentManager realStudentManager, Role roleUser) {
        this.realStudentManager = realStudentManager;
        this.roleUser = roleUser;
    }

    @Override
    public void addStudent(Student student) {
        if (Role.ADMIN == roleUser) {
            realStudentManager.addStudent(student);
        } else {
            System.out.println("Недостаточно прав доступа");
        }
    }

    @Override
    public void deleteStudent(String recordBook) {
        if (Role.ADMIN == roleUser) {
            realStudentManager.deleteStudent(recordBook);
        } else {
            System.out.println("Недостаточно прав доступа");
        }
    }
}
