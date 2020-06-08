package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.infrastucture.User;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.hexagonal.kata.katahexa.infrastucture")
@SpringBootApplication
public class KataHexaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataHexaApplication.class, args);
	}

}
