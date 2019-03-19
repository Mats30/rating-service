package com.rataj.ratingservice.service;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AverageCalculatorTest {

    private final AverageCalculator averageCalculator = new AverageCalculator();

    @Test
    void giveEmptyList_expectZero() {
        double average = averageCalculator.computeAverage(Collections.emptyList());
        assertThat(average).isZero();
    }

    @Test
    void giveListWithOneElement_expectElementValueAsAverage() {
        short elementValue = 6;
        List<Short> givenList = Collections.singletonList(elementValue);
        double average = averageCalculator.computeAverage(givenList);
        assertThat(average).isEqualTo(elementValue);
    }

    @Test
    void giveListWithFewElements_expectAverageValue() {
        List<Integer> givenList = List.of(5, 7, 8, 1, 3);
        double expectedAverage = givenList.stream()
                .mapToDouble(val -> val)
                .average()
                .getAsDouble();
        double actualAverage = averageCalculator.computeAverage(givenList);
        assertThat(actualAverage).isEqualTo(expectedAverage);
    }
}
