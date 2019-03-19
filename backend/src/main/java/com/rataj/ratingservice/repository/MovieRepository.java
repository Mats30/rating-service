package com.rataj.ratingservice.repository;

import com.rataj.ratingservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<Movie, String> {
}
