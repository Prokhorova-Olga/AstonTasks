package ru.aston.hometask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User testUser = new User(25, "Ivan", new ArrayList<>(List.of("A", "B", "C")));
        System.out.println("Создан экземпляр User: " + testUser.getAge() + " " + testUser.getName() + " " + testUser.getDataList());
        SafeUser testSafeUser = new SafeUser(testUser);
        System.out.println("Создан экземпляр SafeUser: " + testSafeUser.getUserCopy());

        testUser.setAge(20);
        testUser.setName("Anna");
        testUser.getDataList().add("D");

        System.out.println("После изменений User: " + testUser.getAge() + " " + testUser.getName() + " " + testUser.getDataList());
        System.out.println("После изменений SafeUser: " + testSafeUser.getUserCopy());
    }
}