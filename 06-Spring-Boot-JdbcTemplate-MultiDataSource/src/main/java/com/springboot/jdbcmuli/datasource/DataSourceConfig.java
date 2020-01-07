package com.springboot.jdbcmuli.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	@Primary
	@Bean(name = "mysqldatasource")
	@ConfigurationProperties("spring.datasource.druid.mysql")
	public DataSource dataSourceOne(){
		//AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		//Object mysqldatasource = application.getBean("mysqldatasource");
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name = "oracledatasource")
	@ConfigurationProperties("spring.datasource.druid.oracle")
	public DataSource dataSourceTwo(){
	    return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
	        @Qualifier("mysqldatasource") DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	@Bean(name = "oracleJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(
	        @Qualifier("oracledatasource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
}
