package com.oddle.tdv.storage.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("config-db.properties")
@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "dbTransactionManager",
        basePackages = {"com.oddle.tdv.storage.db"})
public class DatabaseConfiguration {
    private final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    public DatabaseConfiguration(Environment evn) {
        logger.info("\n\n----> Database Configuration constructor <----\n\n");
        logger.info("\n\n----> Url: {} <----\n\n", evn.getProperty("db.datasource.url"));
    }

    @Primary
    @Bean(name = "userDataSourceProperties")
    @ConfigurationProperties(prefix="db.datasource")
    protected DataSourceProperties userDataSourceProperties() {
        logger.info("\n\n----> Init Bean DataSourceProperties <----\n\n");
        return new DataSourceProperties();
    };

    private DataSource createDataSource(DataSourceProperties properties) {
        return (DataSource) DataSourceBuilder.create(properties.getClassLoader()).type(DataSource.class)
                .driverClassName(properties.determineDriverClassName())
                .url(properties.determineUrl()).username(properties.determineUsername())
                .password(properties.determinePassword()).build();
    }

    @Autowired
    @Bean(name = "dbDataSource")
    public DataSource dataSource(
            @Qualifier("userDataSourceProperties")
                    DataSourceProperties properties) {
        logger.info("\n\n----> Init Bean Database DataSource Url");
        logger.info("\n\n----> Init Bean DataSource Url: {} - UserName/Pass: {} <----\n\n", properties.determineUrl(), properties.determineUsername() + "/" + properties.determinePassword());
        DataSource dataSource = createDataSource(properties);
        DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
        String validationQuery = databaseDriver.getValidationQuery();
        if (validationQuery != null) {
            dataSource.setTestOnBorrow(true);
            dataSource.setValidationQuery(validationQuery);
        }
        return dataSource;
    }

    @Primary
    @Autowired
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dbDataSource") DataSource dataSource) {
        logger.info("\n\n----> Init Bean EntityManagerFactory <----\n\n");
        return builder
                .dataSource(dataSource)
                //TODO add package for Entity here
                .packages("com.oddle.tdv.db.sql.model")
                .persistenceUnit("db")
                .build();
    }

    @Autowired
    @Bean(name = "dbTransactionManager")
    public PlatformTransactionManager dbTransactionManager(
            @Qualifier("entityManagerFactory")
                    EntityManagerFactory entityManagerFactory) {
        logger.info("\n\n----> Init Bean Database TransactionManager Instance JpaTransactionManager <----\n\n");
        return new JpaTransactionManager(entityManagerFactory);
    }

}
