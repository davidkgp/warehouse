package org.example.domain.article.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.article.core.model.vo.ArticleStock;

import java.util.List;

@AllArgsConstructor
@Getter
public class CheckProductArticleStockCommand {
    private final String productName;
    private final List<ArticleStock> articleStockList;
}
