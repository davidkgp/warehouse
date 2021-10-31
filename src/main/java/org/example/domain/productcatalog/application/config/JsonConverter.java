package org.example.domain.productcatalog.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JsonConverter<T> implements Converter<String,T> {

    private final ObjectMapper objectMapper;
    private final Class<T> type;

    @Override
    @SneakyThrows
    public T convert(String source) {
        if(source==null || source.trim().length()==0) throw new IllegalArgumentException("Empty String not allowed");
        return objectMapper.readValue(source.trim(),type);
    }
}
