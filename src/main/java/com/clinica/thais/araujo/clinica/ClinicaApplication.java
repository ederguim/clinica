package com.clinica.thais.araujo.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.clinica.thais.araujo.config.JpaConfiguration;

@EnableJpaRepositories
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.clinica.thais.araujo"})
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}
}
