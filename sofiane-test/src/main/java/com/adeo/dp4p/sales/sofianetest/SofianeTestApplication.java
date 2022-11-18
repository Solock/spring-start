package com.adeo.dp4p.sales.sofianetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SofianeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofianeTestApplication.class, args);
	}

}
