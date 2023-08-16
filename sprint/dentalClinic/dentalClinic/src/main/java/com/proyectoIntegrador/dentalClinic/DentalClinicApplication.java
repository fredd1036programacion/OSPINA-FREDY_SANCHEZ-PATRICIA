package com.proyectoIntegrador.dentalClinic;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DentalClinicApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DentalClinicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicApplication.class, args);
		LOGGER.info("DentalClinic is now running...");
	}

	@GetMapping("hola grupo")
	public String saludar() {
		String saludo = "Hola grupo patricia y fredy";
		LOGGER.info(saludo);
		return saludo;
	}
}

