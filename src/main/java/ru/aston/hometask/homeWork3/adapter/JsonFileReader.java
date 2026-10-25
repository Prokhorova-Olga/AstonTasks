package ru.aston.hometask.homeWork3.adapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonFileReader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_NAME = "studentFields.json";

    public List<Map<String, Object>> read() throws IOException {
        try (InputStream inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Файл не найден: " + FILE_NAME);
            }
            List<Map<String, Object>> mapList = objectMapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {
            });
            return mapList;
        }
    }
}
