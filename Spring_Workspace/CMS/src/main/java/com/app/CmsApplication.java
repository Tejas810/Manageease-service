package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		System.out.println("HI");
		SpringApplication.run(CmsApplication.class, args);
	}

}
