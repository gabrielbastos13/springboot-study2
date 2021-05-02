package com.digitalinnovationone.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String testDatabaseConnection() {
		
		System.out.println("DB connection to DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection to H2_TEST instance";
	}
	@Profile("prod")
	@Bean
	public String productionDatabaseConnection() {
		
		System.out.println("DB connection to production - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection to MYSQL_PROD instance";
	}
}
