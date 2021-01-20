package com.elenakuropatkina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.elenakuropatkina"})
public class AdminUiApplication {

	public static void main (String[]args){
			SpringApplication.run(AdminUiApplication.class, args);
		}

	}
