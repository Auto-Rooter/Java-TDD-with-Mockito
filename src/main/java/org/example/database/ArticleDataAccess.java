package org.example.database;

import org.example.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    /**
     * @return all the articles from today
     */

    List<Article> getTodayArticles();
}