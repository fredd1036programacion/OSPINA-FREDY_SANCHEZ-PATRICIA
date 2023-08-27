package com.proyectoIntegrador.dentalClinic;

import com.proyectoIntegrador.dentalClinic.dao.H2Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;


import java.sql.SQLException;

@SpringBootApplication
public class DentalClinicApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DentalClinicApplication.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(DentalClinicApplication.class, args);
		// OJO HAY QUE TENER MUCHO CUIDADO, CUANDO SE ABRA LA CARPETA EN INTELL, para que funcione el create, debe ser abierte en la cerpta donde se encuentra ya al subcarpeta src, ejemplo de este trabajo, se debe entrar (open en intell) a la carpeta de dentalClinic hasta donde las capetas de src ya sea la proxima en abrirse
		H2Connection.create();
		LOGGER.info("ClinicaOdontologica is now running...");

	}

	@GetMapping("hola")
	public String saludar(){
		String saludo = "Hola Camada 4";
		LOGGER.info(saludo);
		return saludo;
	}



}

