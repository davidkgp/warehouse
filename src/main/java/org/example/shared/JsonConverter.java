package org.example.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class JsonConverter<T> {

    private final ObjectMapper objectMapper;
    private final Class<T> type;

    @SneakyThrows
    public T convert(String source) {
        if (source == null || source.trim().length() == 0)
            throw new IllegalArgumentException("Empty String not allowed");
        return objectMapper.readValue(source.trim(), type);
    }
}
