package com.oddle.tdv.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//TODO Spring configuration scan package
@SpringBootApplication(scanBasePackages = "com.oddle.tdv")
@ImportResource("classpath:application-config.xml")
public class ShopTdvApplication {

	public static void main(String[] args) {
        SpringApplication.run(ShopTdvApplication.class, args);
	}
}
