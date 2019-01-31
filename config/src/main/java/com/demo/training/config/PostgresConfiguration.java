//package com.demo.training.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "xOrderEntityManagerFactory")
//public class PostgresConfiguration {
//
//  @Bean
//  @ConfigurationProperties(prefix = "x.order.dataSource")
//  public DataSource xOrderDataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean xOrderEntityManagerFactory(
//      EntityManagerFactoryBuilder builder, @Qualifier("xOrderDataSource") DataSource dataSource) {
//    return builder.dataSource(dataSource).packages("com.gdn.data.synchronize.entity.postgres")
//        .persistenceUnit("orderXOrder").build();
//  }
//
//  @Primary
//  @Bean(name = "transactionManager")
//  public PlatformTransactionManager transactionManager(
//      @Qualifier("xOrderEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//    return new JpaTransactionManager(entityManagerFactory);
//  }
//}
