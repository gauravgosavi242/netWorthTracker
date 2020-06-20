package com.github.gauravgosavi.networthtracker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.github.gauravgosavi.networthtracker")
public class NetworthtrackerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(NetworthtrackerApplication.class, args);
	}

}
