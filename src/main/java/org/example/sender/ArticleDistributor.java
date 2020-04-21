package org.example.sender;

import org.example.article.Article;
import org.example.client.Channel;
import org.example.database.ArticleDataAccess;

/*
* Work through today`s articles sending them out to the right places
 */
public class ArticleDistributor {
    private Channel sport;
    private Channel entertainment;
    private Channel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(Channel sport, Channel entertainment, Channel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays(){
        for(Article article: dataAccess.getTodayArticles()){
            switch(article.getType()){
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    other.accept(article);
                    break;
            }
        }
    }
}
