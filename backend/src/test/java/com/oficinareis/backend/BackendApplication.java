package com.oficinareis.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @SpringBootApplication por padrão escaneia a pasta e subpastas.
// Se você tem controladores em pacotes diferentes, essas anotações adicionais ajudam:
@SpringBootApplication
@ComponentScan(basePackages = { "com.oficinareis.backend" }) // Garante que todos os controllers/services sejam
																// encontrados
@EntityScan(basePackages = { "com.oficinareis.backend.model" }) // Garante que as entidades sejam encontradas
@EnableJpaRepositories(basePackages = { "com.oficinareis.backend.repository" }) // Garante que os repositórios sejam
																				// encontrados
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}