package com.rataj.ratingservice;


import com.rataj.ratingservice.model.Genre;
import com.rataj.ratingservice.model.Movie;
import com.rataj.ratingservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class RatingService {

    @Autowired
    MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(RatingService.class);
    }

//    init DB with few movies
    @Profile("prod")
    @Bean
    CommandLineRunner initDb() {
        return (args) -> {
            movieRepository.save(new Movie("Titanic", LocalDate.parse("2018-10-09"), Genre.DRAMA));
            movieRepository.save(new Movie("Cars", LocalDate.parse("2015-06-23"), Genre.ANIMATION));
            movieRepository.save(new Movie("Deadpool", LocalDate.parse("2018-09-01"), Genre.COMEDY));
            movieRepository.save(new Movie("Fast&Furious", LocalDate.parse("2018-05-09"), Genre.ACTION));
            movieRepository.save(new Movie("Adam Małysz", LocalDate.parse("2018-11-12"), Genre.SAGA));
        };
    }
}
