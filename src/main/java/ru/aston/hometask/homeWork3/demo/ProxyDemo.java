package ru.aston.hometask.homeWork3.demo;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.proxy.RealStudentManager;
import ru.aston.hometask.homeWork3.proxy.Role;
import ru.aston.hometask.homeWork3.proxy.StudentManager;
import ru.aston.hometask.homeWork3.proxy.StudentManagerProxy;

public class ProxyDemo {

    public static void main(String[] args) {

        Student student = Student.builder().group("А-1").averageGrade(3.6).recordBook("11671").build();
        RealStudentManager realStudentManager = new RealStudentManager();

        System.out.println("Если обычный пользователь");
        StudentManager userProxy = new StudentManagerProxy(realStudentManager, Role.USER);
        userProxy.addStudent(student);
        userProxy.deleteStudent("11671");

        System.out.println("Если администратор");
        StudentManager adminProxy = new StudentManagerProxy(realStudentManager, Role.ADMIN);
        adminProxy.addStudent(student);
        adminProxy.deleteStudent("11971");
    }
}
