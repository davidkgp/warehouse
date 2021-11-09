package org.example.domain.article.core.ports.incoming;

import org.example.domain.article.core.model.command.ReduceArticleCommand;

public interface ReduceArticleStock {
    void handle(ReduceArticleCommand reduceArticleCommand);
}
