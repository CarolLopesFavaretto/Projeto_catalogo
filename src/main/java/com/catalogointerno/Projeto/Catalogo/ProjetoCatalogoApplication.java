package com.catalogointerno.Projeto.Catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication

public class ProjetoCatalogoApplication {



	public static void main(String[] args) {
		SpringApplication.run(ProjetoCatalogoApplication.class, args);
	}

}
