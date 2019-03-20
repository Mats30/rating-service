package com.rataj.ratingservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.OptionalDouble;

class AverageCalculator {

    <T extends Number> double computeAverage(Collection<T> collection) {
        OptionalDouble average = collection.stream()
                .mapToDouble(Number::doubleValue)
                .average();
        return round(average.orElse(0));
    }

    private double round(double value) {
        if (value == 0) return 0;

        BigDecimal decimal = BigDecimal.valueOf(value);
        decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

}
