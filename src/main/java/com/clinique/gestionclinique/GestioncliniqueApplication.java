package com.clinique.gestionclinique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class GestioncliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioncliniqueApplication.class, args);
	}

}
