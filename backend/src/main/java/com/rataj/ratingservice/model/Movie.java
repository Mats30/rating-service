package com.rataj.ratingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Document
public final class Movie {

    @Id
    private String id;
    private String title;
    private LocalDate date;
    private Genre genre;
    private List<Integer> ratings;

    public Movie(String title, LocalDate date, Genre genre) {
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.ratings = new LinkedList<>();
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public LocalDate date() {
        return date;
    }

    public Genre genre() {
        return genre;
    }

    public List<Integer> ratings() {
        return ratings;
    }


    public void addRating(int rating) {
        this.ratings.add(rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", genre=" + genre +
                ", ratings=" + ratings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(date, movie.date) &&
                genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, genre);
    }
}
