package com.rataj.ratingservice.endpoint;

import com.rataj.ratingservice.model.Genre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/genres")
@RestController
class GenreEndpoint {

    @GetMapping
    Genre[] fetchAllGenres() {
        return Genre.values();
    }

}
