package com.gcil.cms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gcil.cms")
public class GcilCmsApp {

	public static void main(String[] args) {

		SpringApplication.run(GcilCmsApp.class, args);

	}
	
}

 		