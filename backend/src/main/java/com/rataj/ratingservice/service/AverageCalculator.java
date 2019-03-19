package com.rataj.ratingservice.service;

import java.util.Collection;
import java.util.OptionalDouble;

class AverageCalculator {

    <T extends Number> double computeAverage(Collection<T> collection) {
        OptionalDouble average = collection.stream()
                .mapToDouble(Number::doubleValue)
                .average();
        return average.orElse(0);
    }

}
