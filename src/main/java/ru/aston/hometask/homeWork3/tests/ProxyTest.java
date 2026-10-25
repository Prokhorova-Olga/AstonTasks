package ru.aston.hometask.homeWork3.tests;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.builder.StudentBuilder;
import ru.aston.hometask.homeWork3.proxy.RealStudentManager;
import ru.aston.hometask.homeWork3.proxy.StudentManager;
import ru.aston.hometask.homeWork3.proxy.StudentManagerProxy;

public class ProxyTest {

    public static void main(String[] args) {

        Student student = new StudentBuilder().setGroup("А-1").setAverageGrade(3.6).setRecordBook("11671").build();
        RealStudentManager realStudentManager = new RealStudentManager();

        System.out.println("Если обычный пользователь");
        StudentManager userProxy = new StudentManagerProxy(realStudentManager, "USER");
        userProxy.addStudent(student);
        userProxy.deleteStudent("11671");

        System.out.println("Если администратор");
        StudentManager adminProxy = new StudentManagerProxy(realStudentManager, "ADMIN");
        adminProxy.addStudent(student);
        adminProxy.deleteStudent("11671");
    }
}
