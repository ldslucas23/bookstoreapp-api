package com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bookstore.service.DBService;

//Indica que é uma classe de configuração
@Configuration
//Quando o perfil ativo indicado no application.properties for test essa classe vai ser chamada
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	// Essa anotação vai indicar que quando eu subir a aplicação nesse perfil esse
	// método vai ser chamado
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
