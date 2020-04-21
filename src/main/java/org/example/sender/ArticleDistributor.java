package org.example.sender;

import org.example.article.Article;
import org.example.client.Channel;
import org.example.client.EntertainmentChannel;
import org.example.client.OtherChannel;
import org.example.client.SportChannel;
import org.example.database.ArticleDataAccess;

/*
* Work through today`s articles sending them out to the right places
 */
public class ArticleDistributor {
    private SportChannel sport;
    private EntertainmentChannel entertainment;
    private OtherChannel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
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
