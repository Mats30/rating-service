package com.rataj.ratingservice.endpoint;

import com.rataj.ratingservice.model.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class MovieEndpointExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MovieEndpointExceptionHandler.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.code = HttpStatus.NOT_FOUND.value();
        errorDto.message = "Movie not found: " + exception.getLocalizedMessage();
        LOG.error(exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ErrorDto> handleServerException(Exception exception, WebRequest request) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        errorDto.message = "Unexpected server error: " + exception.getLocalizedMessage();
        LOG.error(exception.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
