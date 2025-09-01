package com.utfpr.musical_api.backend_musical_api.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.utfpr.musical_api.backend_musical_api.repository")
@EnableTransactionManagement
public class SpringDataConfig {
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setUsername("sanrise");
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mariadb://192.168.18.193:3306");
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.utfpr.musical_api.backend_musical_api.entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setJpaDialect(new HibernateJpaDialect());

        return transactionManager;
    }
}
