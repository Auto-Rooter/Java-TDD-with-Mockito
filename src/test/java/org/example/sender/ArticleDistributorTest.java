package org.example.sender;

import org.example.article.Article;
import org.example.article.Type;
import org.example.client.Channel;
import org.example.client.EntertainmentChannel;
import org.example.client.OtherChannel;
import org.example.client.SportChannel;
import org.example.database.ArticleDataAccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {
    @Mock
    private SportChannel sport ;

    @Mock
    private EntertainmentChannel entertainment ;

    @Mock
    private OtherChannel other ;

    @Mock
    private ArticleDataAccess dataAccess;

    @InjectMocks
    private ArticleDistributor distributor;

    @Test
    public void sportGoesToSportPoliticsToOther(){
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