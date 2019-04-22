package com.gameFx.hiRank.model;

import com.gameFx.hiRank.bean.HibernateConf;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class TestBeans extends HibernateConf{

    @Bean
    public TestEntityManager testEntityManager() {
        return new TestEntityManager(entityManagerFactory());
    }
}
