package com.rataj.ratingservice.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LocalDateDeserializerTest {

    private final LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer();

    private JsonParser jsonParser = mock(JsonParser.class);
    private DeserializationContext deserializationContext = mock(DeserializationContext.class);

    @Test
    void deserializeLocalDate_expectValidStringWithExpectedFormat() throws IOException {
        String givenDate = "20-03-2019";
        when(jsonParser.getText()).thenReturn(givenDate);
        LocalDate expectedDate = LocalDate.of(2019, 3, 20);
        LocalDate actualDate = localDateDeserializer.deserialize(jsonParser, deserializationContext);
        assertThat(actualDate).isEqualTo(expectedDate);
    }


}
