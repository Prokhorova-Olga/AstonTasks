package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int age;
    private String name;
    private List<String> data;

    public User(int age, String name, List<String> tags) {
        this.age = age;
        this.name = name;
        this.data = new ArrayList<>(tags);
    }

    public User(User user) {
        this.age = user.getAge();
        this.name = user.getName();
        this.data = new ArrayList<>(user.getDataList());
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getDataList() {
        return data;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataList(List<String> tags) {
        this.data = tags;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
