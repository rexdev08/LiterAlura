package com.rexdev08.LiterAlura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rexdev08.LiterAlura.menu.Menu;

@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LiterAluraApplication.class, args);
		Menu menu = context.getBean(Menu.class);
		menu.iniciar();
	}

}
