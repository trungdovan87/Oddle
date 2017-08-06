package com.oddle.tdv.gateway.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.oddle.tdv")
public class ShopTdvApplication {

	public static void main(String[] args) {
        SpringApplication.run(ShopTdvApplication.class, args);
	}
}
