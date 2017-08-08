package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"dev.paie.service", "dev.paie.util"})
public class ServicesConfig {

}
