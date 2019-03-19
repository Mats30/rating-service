package com.rataj.ratingservice.service;

import com.rataj.ratingservice.endpoint.dto.AddRatingRequest;
import com.rataj.ratingservice.model.Movie;
import com.rataj.ratingservice.model.MovieDto;
import com.rataj.ratingservice.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
final class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieDtoFactory factory;

    MovieServiceImpl(MovieRepository movieRepository, MovieDtoFactory factory) {
        this.movieRepository = movieRepository;
        this.factory = factory;
    }

    @Override
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        List<MovieDto> dtos = movies.stream()
                .map(factory::movieDtoFromMovie)
                .collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public MovieDto updateRating(String id, AddRatingRequest request) {
        Optional<Movie> movieFromDb = movieRepository.findById(id);

        return movieFromDb.map(movie -> {
            movie.addRating(request.rate);
            movieRepository.save(movie);
            return factory.movieDtoFromMovie(movie);
        }).orElseThrow(IllegalArgumentException::new);
    }

}
