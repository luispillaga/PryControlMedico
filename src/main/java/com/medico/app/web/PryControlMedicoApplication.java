package com.medico.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PryControlMedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PryControlMedicoApplication.class, args);
	}

}
