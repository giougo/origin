package com.prestador.saude.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {
	
	private static final String NOME_LOGGER = "logger_prestador_saude";

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(NOME_LOGGER);
	}
}
