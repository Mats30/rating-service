package com.rataj.ratingservice.service;

import com.rataj.ratingservice.endpoint.dto.AddRatingRequest;
import com.rataj.ratingservice.model.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    Page<MovieDto> findAll(Pageable pageable);
    MovieDto updateRating(String id, AddRatingRequest request);
}
