package com.gameFx.hiRank.search;

import com.gameFx.hiRank.model.Game;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class SimilarSearch implements CustomSearch{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<Game> search(String criteria) {
        EntityManager em = entityManagerFactory.createEntityManager();
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

        MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[]{"name"}, new StandardAnalyzer());
        org.apache.lucene.search.Query query = null;

        try {
            query = parser.parse(criteria);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Game.class);
        List result = persistenceQuery.getResultList();

        closeTransaction(em);
        return result;
    }


    private void closeTransaction(EntityManager em){
        em.getTransaction().commit();
        em.close();
    }
}
