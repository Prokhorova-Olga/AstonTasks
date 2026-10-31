package ru.aston.hometask.homeWork2;

import java.util.Objects;

public class Book {
    private String title;
    private String authorName;
    private String authorSurname;
    private int year;
    private int page;

    public Book() {
    }

    public Book(String title, String authorName, String authorSurname, int year, int page) {
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.year = year;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && page == book.page && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName) && Objects.equals(authorSurname, book.authorSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, authorSurname, year, page);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", year=" + year +
                ", page=" + page +
                '}';
    }
}
