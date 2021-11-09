package org.example.shared.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.article.application.rest.input.ArticleInventory;
import org.example.shared.JsonConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfigurations {

    @Bean
    @Qualifier("articleJsonParser")
    public JsonConverter<ArticleInventory> getJsonConverterForArticleInventory(final ObjectMapper objectMapper) {
        return new JsonConverter<>(objectMapper, ArticleInventory.class);
    }


}
