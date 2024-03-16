package com.ayoub.real_estate.rest.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class RealEstateRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateRestApplication.class, args);
	}

}
