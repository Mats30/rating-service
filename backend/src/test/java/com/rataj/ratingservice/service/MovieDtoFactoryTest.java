package com.rataj.ratingservice.service;

import com.rataj.ratingservice.model.Genre;
import com.rataj.ratingservice.model.Movie;
import com.rataj.ratingservice.model.MovieDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MovieDtoFactoryTest {


    private final MovieDtoFactory factory = new MovieDtoFactory();

    @Test
    void giveMovieObject_expectMovieDtoObjectWithCalculatedAverage() {
        Movie givenMovie = new Movie("Cars", LocalDate.of(2018, 11, 30), Genre.ANIMATION);

        MovieDto actualMovieDto = factory.movieDtoFromMovie(givenMovie);

        assertThat(actualMovieDto.title).isEqualTo(givenMovie.title());
        assertThat(actualMovieDto.date).isEqualTo(givenMovie.date());
        assertThat(actualMovieDto.genre).isEqualTo(givenMovie.genre());
        assertThat(actualMovieDto.averageRating).isZero();
    }

}
