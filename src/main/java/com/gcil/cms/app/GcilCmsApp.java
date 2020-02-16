package com.gcil.cms.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gcil.cms.app")
public class GcilCmsApp {
	
	private static final Logger logger =  LoggerFactory.getLogger(GcilCmsApp.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(GcilCmsApp.class, args);
		
		
	}

}
