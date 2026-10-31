package ru.aston.hometask.homeWork2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentReader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_NAME = "students.json";

    public List<Student> read() throws IOException {
        try (InputStream inputStream = StudentReader.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Файл не найден: " + FILE_NAME);
            }
            List<Student> students = objectMapper.readValue(inputStream, new TypeReference<List<Student>>() {
            });
            return students;
        }
    }
}