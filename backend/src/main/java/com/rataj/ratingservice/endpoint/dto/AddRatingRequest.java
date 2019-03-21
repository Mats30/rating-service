package com.rataj.ratingservice.endpoint.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
public class AddRatingRequest {

    @Min(value = 1, message = "Rating should be greater than or equal 1")
    @Max(value = 10, message = "Rating should be less than or equal 10")
    public Integer rate;


    public AddRatingRequest(){}
}
