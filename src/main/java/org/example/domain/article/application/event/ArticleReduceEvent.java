package org.example.domain.article.application.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.javatuples.Pair;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticleReduceEvent {

   private List<Pair<String,Integer>> reductions;

}
