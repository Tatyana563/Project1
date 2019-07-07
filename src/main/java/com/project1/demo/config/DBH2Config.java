package com.project1.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages="com.project1.demo.repository")
@Profile("DBh2")
public class DBH2Config {
    @Bean
    public DataSource dataSource(){
        HikariConfig dataSource = new HikariConfig();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("user");
        dataSource.setPassword("");
        dataSource.setJdbcUrl( "jdbc:h2:mem:demo;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS UTL_MATCH\\;CREATE SCHEMA IF NOT EXISTS demo\\;SET SCHEMA demo;MVCC=true");
        return new HikariDataSource(dataSource);
    }
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.H2);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.project1.demo");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show_sql","true");
        entityManagerFactoryBean.setJpaProperties(properties);
        return entityManagerFactoryBean;
    }
}
