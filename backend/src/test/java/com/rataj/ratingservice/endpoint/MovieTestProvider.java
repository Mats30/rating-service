package com.rataj.ratingservice.endpoint;

import com.rataj.ratingservice.model.Genre;
import com.rataj.ratingservice.model.Movie;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class MovieTestProvider {

    private MovieTestProvider() {   }

    public static List<Movie> testMovies() {
        List<Movie> testMovies = new LinkedList<>();
        testMovies.add(new Movie("Titanic", LocalDate.parse("2018-10-09"), Genre.DRAMA));
        testMovies.add(new Movie( "Cars", LocalDate.parse("2018-09-09"), Genre.ANIMATION));
        testMovies.add(new Movie( "Deadpool", LocalDate.parse("2018-09-09"), Genre.COMEDY));
        testMovies.add(new Movie( "Fast&Furious", LocalDate.parse("2018-09-09"), Genre.ACTION));
        testMovies.add(new Movie( "Adam Małysz", LocalDate.parse("2018-09-09"), Genre.SAGA));
        return testMovies;
    }

    public static Movie singleMovie() {
        Movie movie = new Movie("Titanic", LocalDate.parse("2018-03-20"), Genre.DRAMA);
        ReflectionTestUtils.setField(movie, "id", "1");
        return movie;
    }
}
