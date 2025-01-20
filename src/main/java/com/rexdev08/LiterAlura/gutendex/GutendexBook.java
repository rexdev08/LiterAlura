package com.rexdev08.LiterAlura.gutendex;

import java.util.List;

public class GutendexBook {

    private String title;
    private String language;
    private Integer year;
    private List<AutorGutendex> authors;

    // Getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<AutorGutendex> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AutorGutendex> authors) {
        this.authors = authors;
    }
}
