package com.rataj.ratingservice.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rataj.ratingservice.endpoint.dto.AddRatingRequest;
import com.rataj.ratingservice.model.Movie;
import com.rataj.ratingservice.model.MovieDto;
import com.rataj.ratingservice.repository.MovieRepository;
import com.rataj.ratingservice.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class MovieEndpointIntTest {

    private static final String MOVIES_URI = "/v1/movies";

    @Autowired
    MovieService movieService;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean(name = "movieRepository")
    MovieRepository movieRepository;

    private MockMvc mockMvc;
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @BeforeEach
    void init() {
        mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        mockMvc = standaloneSetup(new MovieEndpoint(movieService))
                .setControllerAdvice(new MovieEndpointExceptionHandler())
                .setMessageConverters(mappingJackson2HttpMessageConverter)
                .build();
    }

    @Test
    void updateRatingOfExistingMovie_expectDtoWithValidNewAverage() throws Exception {
        Movie movieFromDb = MovieTestProvider.singleMovie();
        when(movieRepository.findById(anyString())).thenReturn(Optional.of(movieFromDb));

        AddRatingRequest addRatingRequest = new AddRatingRequest();
        addRatingRequest.rate = 5;

        MovieDto expectedMovieDto = new MovieDto();
        expectedMovieDto.id = movieFromDb.id();
        expectedMovieDto.title = movieFromDb.title();
        expectedMovieDto.genre = movieFromDb.genre();
        expectedMovieDto.date = movieFromDb.date();
        expectedMovieDto.averageRating = 5.0;


        mockMvc.perform(post(MOVIES_URI + "/1/rate")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(addRatingRequest)))
                                    .andExpect(content().string(objectMapper.writeValueAsString(expectedMovieDto)))
                                    .andExpect(status().isOk());
    }

}
