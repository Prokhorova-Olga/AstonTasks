package ru.aston.hometask.homeWork3.adapter;

import ru.aston.hometask.homeWork3.builder.Student;
import ru.aston.hometask.homeWork3.builder.StudentBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonStudentAdapter implements StudentProvider {

    private final JsonFileReader fileReader = new JsonFileReader();

    @Override
    public List<Student> read() throws IOException {
        List<Map<String, Object>> mapList = fileReader.read();
        List<Student> students = new ArrayList<>();

        for (Map<String, Object> studentMap : mapList) {
            Object groupObject = studentMap.get("group");
            Object averageGradeObject = studentMap.get("averageGrade");
            Object recordBookObject = studentMap.get("recordBook");
            if (groupObject == null || averageGradeObject == null || recordBookObject == null) {
                continue;
            }
            String group = (String) studentMap.get("group");
            double averageGrade = ((Number) studentMap.get("averageGrade")).doubleValue();
            String recordBook = (String) studentMap.get("recordBook");

            Student student = new StudentBuilder()
                    .setGroup(group)
                    .setAverageGrade(averageGrade)
                    .setRecordBook(recordBook)
                    .build();
            students.add(student);
        }
        return students;
    }
}
