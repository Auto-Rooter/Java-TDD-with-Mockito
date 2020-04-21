package org.example.sender;

import org.example.article.Article;
import org.example.article.Type;
import org.example.client.Channel;
import org.example.database.ArticleDataAccess;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

public class ArticleDistributorTest {

    @Test
    public void sportGoesToSportPoliticsToOther(){
        Channel sport = mock(Channel.class);
        Channel entertainment = mock(Channel.class);
        Channel other = mock(Channel.class);

        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);
        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);

        // Given this list of articles is returned from the database
         List<Article> list = asList(
                 new Article("Sport is fun", Type.SPORT),
                 new Article("Politics is sad", Type.FINANCE));

         when(dataAccess.getTodayArticles()).thenReturn(list);
         //When we distribute
         distributor.distributeTodays();

         // then one goes to sport and one goes to other
         verify(sport).accept((Article) any());
         verify(other).accept((Article) any());
         verify(entertainment, never()).accept((Article) any());
    }
}