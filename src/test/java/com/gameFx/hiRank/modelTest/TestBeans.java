package com.gameFx.hiRank.modelTest;

import com.gameFx.hiRank.bean.HibernateConf;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static com.gameFx.hiRank.bean.ConfigurationConstants.*;

@Configuration
@EnableTransactionManagement

public class TestBeans extends HibernateConf{

    @Bean
    public TestEntityManager testEntityManager() {
        return new TestEntityManager(entityManagerFactory());
    }
}
