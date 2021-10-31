package org.example.domain.productcatalog.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonConverterTest {


    @Test
    @DisplayName("Test json converter with properly formed json")
    public void testJsonConverterWithProperString() {
        String json ="[1,2,3,4]";
        JsonConverter<Integer[]> integerArrayJsonConverter = new JsonConverter<>(new ObjectMapper(),Integer[].class);
        Integer[] actual = integerArrayJsonConverter.convert(json);

        assertNotNull(actual);
        assertEquals(4, actual.length);
        Integer[] expected = new Integer[]{1,2,3,4};
        assertArrayEquals(actual, expected);

    }

    @Test
    @DisplayName("Test json converter with empty string")
    public void testJsonConverterWithEmptyString() {
        String json ="";
        JsonConverter<Integer[]> integerArrayJsonConverter = new JsonConverter<>(new ObjectMapper(),Integer[].class);
        assertThrows(IllegalArgumentException.class,()->integerArrayJsonConverter.convert(json));


    }
    @Test
    @DisplayName("Test json converter with null string")
    public void testJsonConverterWithNullString() {
        JsonConverter<Integer[]> integerArrayJsonConverter = new JsonConverter<>(new ObjectMapper(),Integer[].class);
        assertThrows(IllegalArgumentException.class,()->integerArrayJsonConverter.convert(null));


    }

}