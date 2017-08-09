package dev.paie.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"dev.paie.ihm"})
@Import({ServicesConfig.class})
public class AppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
