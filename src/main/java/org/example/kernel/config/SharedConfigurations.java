package org.example.kernel.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.article.application.rest.input.ArticleInventory;
import org.example.domain.productcatalog.application.rest.input.Products;
import org.example.kernel.JsonConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SharedConfigurations {

    @Bean
    @Qualifier("articleJsonParser")
    public JsonConverter<ArticleInventory> getJsonConverterForArticleInventory(final ObjectMapper objectMapper) {
        return new JsonConverter<>(objectMapper, ArticleInventory.class);
    }

    @Bean
    @Qualifier("productJsonParser")
    public JsonConverter<Products> getJsonConverterForProductCatalog(final ObjectMapper objectMapper) {
        return new JsonConverter<>(objectMapper, Products.class);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
