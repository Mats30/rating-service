package com.rataj.ratingservice.model;


import java.time.LocalDate;

public final class MovieDto {

    public String id;
    public String title;
    public LocalDate date;
    public Genre genre;
    public Double averageRating;
}
