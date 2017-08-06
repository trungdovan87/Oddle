package com.oddle.tdv.gateway;

import com.oddle.tdv.Trung;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopTdvApplication {

	public static void main(String[] args) {
	    System.out.println(Trung.a);
        SpringApplication.run(ShopTdvApplication.class, args);
	}
}
