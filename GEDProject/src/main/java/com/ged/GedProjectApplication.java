package com.ged;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GedProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GedProjectApplication.class, args);
		
		System.out.print("-----------------------------------------------Démmarage de l'application-----------------------");
	}
}
