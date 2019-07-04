package com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursomc.services.DBservice;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBservice dbService;
	
	@Bean
	public boolean instantiateDatabasse() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
}
