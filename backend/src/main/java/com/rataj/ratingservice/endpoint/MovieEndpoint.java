package com.rataj.ratingservice.endpoint;


import com.rataj.ratingservice.endpoint.dto.AddRatingRequest;
import com.rataj.ratingservice.model.MovieDto;
import com.rataj.ratingservice.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/movies")
@RestController
class MovieEndpoint {

    private final MovieService movieService;

    MovieEndpoint(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    ResponseEntity<Page<MovieDto>> getMoviesPage(Pageable pageable) {
        Page<MovieDto> page = movieService.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/{id}/rate")
    ResponseEntity<MovieDto> addRating(@PathVariable String id, @Validated @RequestBody AddRatingRequest request) {
        MovieDto updatedMovie = movieService.updateRating(id, request);
        return ResponseEntity.ok(updatedMovie);
    }

}
