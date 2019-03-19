package com.rataj.ratingservice.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class LocalDateSerializerTest {

    private final LocalDateSerializer localDateSerializer = new LocalDateSerializer();

    private final JsonGenerator jsonGenerator = mock(JsonGenerator.class);
    private final SerializerProvider serializerProvider = mock(SerializerProvider.class);
    private final ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    @Test
    void serializeLocalDate_expectDateAsStringInValidFormat() throws IOException {
        doNothing().when(jsonGenerator).writeString(argumentCaptor.capture());
        LocalDate givenDate = LocalDate.of(2019, 3, 20);
        String expectedDate = "20-03-2019";
        localDateSerializer.serialize(givenDate, jsonGenerator, serializerProvider);
        String actualDate = argumentCaptor.getValue();
        assertThat(actualDate).isEqualTo(expectedDate);
    }

}
