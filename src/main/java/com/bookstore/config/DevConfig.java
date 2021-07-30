package com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bookstore.service.DBService;

//Indica que é uma classe de configuração
@Configuration
//Quando o perfil ativo indicado no application.properties for test essa classe vai ser chamada
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	//Pega o valor da propriedade do application-dev.properties e verifica como o banco vai subir
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		
		//Se a propriedade do application-dev.properties for igual a create
		//Criamos a base novamente
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
	
}
