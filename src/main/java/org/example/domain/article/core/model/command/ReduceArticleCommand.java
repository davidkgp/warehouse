package org.example.domain.article.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReduceArticleCommand {

    private final String articleId;
    private final int reduction;
}
