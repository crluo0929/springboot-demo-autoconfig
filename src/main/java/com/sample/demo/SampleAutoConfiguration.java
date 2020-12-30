package com.sample.demo;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ LocalContainerEntityManagerFactoryBean.class, EntityManager.class, PlatformTransactionManager.class})
@AutoConfigureAfter(H2ConsoleAutoConfiguration.class)
@EnableConfigurationProperties({SampleH2ConfigurationProperties.class})

@EnableJpaRepositories(basePackages = "${sample.repoBasepackage}",entityManagerFactoryRef = "sampleEntityManagerFactory")
//@EntityScan(basePackages = "${sample.entityBasepackage}") //EntityScan似乎不支援${expression}
public class SampleAutoConfiguration {

	@Autowired SampleH2ConfigurationProperties prop ;
	@Autowired DataSource datasource ;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean sampleEntityManagerFactory(){       
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(datasource);
	    emf.setPackagesToScan(prop.getEntityBasepackage());
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    Properties props = new Properties() ;
	    props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect") ;
	    emf.setJpaVendorAdapter(vendorAdapter);
	    emf.setJpaProperties(props);
	    return emf ;
	} 
	
//	@Bean
//	public PlatformTransactionManager sampleTransactionManager() {
//	    JpaTransactionManager tm = new JpaTransactionManager();
//	    tm.setEntityManagerFactory( sampleEntityManagerFactory().getObject() );
//	    return tm ;
//	}
	
}
