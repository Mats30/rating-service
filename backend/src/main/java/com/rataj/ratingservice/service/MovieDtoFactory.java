package com.rataj.ratingservice.service;

import com.rataj.ratingservice.model.Movie;
import com.rataj.ratingservice.model.MovieDto;
import org.springframework.stereotype.Component;

@Component
class MovieDtoFactory {

    private final AverageCalculator averageService;

    MovieDtoFactory() {
        this.averageService = new AverageCalculator();
    }

    MovieDto movieDtoFromMovie(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.id = movie.id();
        dto.title = movie.title();
        dto.date = movie.date();
        dto.genre = movie.genre();
        dto.averageRating = averageService.computeAverage(movie.ratings());
        return dto;
    }

}
