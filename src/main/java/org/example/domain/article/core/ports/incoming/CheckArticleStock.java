package org.example.domain.article.core.ports.incoming;

import org.example.domain.article.core.model.command.CheckProductArticleStockCommand;

public interface CheckArticleStock {
    void handle(CheckProductArticleStockCommand checkArticleStockCommand);
}
