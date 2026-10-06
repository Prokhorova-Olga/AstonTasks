package ru.aston.hometask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private int age;
    private String name;
    private List<String> data;

    public User(int age, String name, List<String> data) {
        this.age = age;
        this.name = name;
        this.data = new ArrayList<>(data);
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

    public void setDataList(List<String> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(data, user.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, data);
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
