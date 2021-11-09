package org.example.domain.article.application.rest;

import lombok.RequiredArgsConstructor;
import org.example.kernel.output.ResponseMessage;
import org.example.domain.article.application.rest.input.ArticleInventory;
import org.example.domain.article.core.model.Article;
import org.example.domain.article.core.ports.incoming.AddArticles;
import org.example.kernel.JsonConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {


    @Qualifier("addArticles")
    private final AddArticles addArticles;

    @Qualifier("articleJsonParser")
    private final JsonConverter<ArticleInventory> articleParser;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") final MultipartFile file) throws IOException {

        String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        ArticleInventory articleInventory = articleParser.convert(fileContent);


        if (articleInventory != null && (articleInventory.getArticleLines() == null || articleInventory.getArticleLines().length == 0)) {
            return ResponseEntity.badRequest().build();
        }
        List<Article> articles = Arrays.stream(articleInventory.getArticleLines())
                .map(articleLine -> new Article(articleLine.getId(), articleLine.getName(), articleLine.getStock()))
                .collect(Collectors.toList());
        ResponseMessage responseMessage = new ResponseMessage(String.format("%s Articles Saved", addArticles.handle(articles)));
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);

    }


}
