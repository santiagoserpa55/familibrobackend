package com.epsfamiliar.familibro.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

// beans de configuraciones para conectarnos a la DB
@Configuration
public class DatabaseConfig {
	/*
	 * bean especial que tiene toda la info para conectarse y dice - > hay una
	 * conexion que tendra la siguiente configuracion
	 */
	@Bean
	@ConfigurationProperties(prefix = "datasource.my-connection")
	public DataSource crudDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate crudJdbcTemplate(DataSource crudDataSource) {
		var jdbcTemplate = new JdbcTemplate(crudDataSource); // le pasamos la conex del bean anterior //DataSource
		return jdbcTemplate;
		
	}
	
	// este te permite trabajar con parametros mucho mas facil
	@Bean
	public NamedParameterJdbcTemplate crudNamedParameterJdbcTemplate(JdbcTemplate crudSecJdbcTemplate) {
		return new NamedParameterJdbcTemplate(crudSecJdbcTemplate);
	}
	
}
