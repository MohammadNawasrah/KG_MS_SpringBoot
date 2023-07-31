package com.KG.KGMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class KgmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KgmsApplication.class, args);
	}

}
