package com.rct.app;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Configuration
	public static class PostgresDataSource {
		@Bean
		@ConfigurationProperties("app.datasource")
		public HikariDataSource hikariDataSource(){
			return DataSourceBuilder
					.create()
					.type(HikariDataSource.class)
					.build();
		}
	}
}
