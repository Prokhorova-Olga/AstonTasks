package ru.aston.hometask.homeWork2;

import java.util.Comparator;
import java.util.List;

public class StudentBookService {

    private static final int MIN_YEAR = 2000;
    private static final int MAX_BOOKS = 3;
    private final List<Student> students;

    public StudentBookService(List<Student> students) {
        this.students = students;
    }

    public void printResult() {
        students.stream()
                .peek(student -> System.out.println("Информация о студенте " + student))
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPage))
                .distinct()
                .filter(book -> book.getYear() > MIN_YEAR)
                .limit(MAX_BOOKS)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Книга не найдена"));
    }
}
