package ru.aston.hometask.homeWork3.adapter;

import ru.aston.hometask.homeWork3.builder.Student;

import java.io.IOException;
import java.util.List;

public interface StudentProvider {

    List<Student> read() throws IOException;
}
