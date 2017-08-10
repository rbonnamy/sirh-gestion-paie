package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

/** Classes de config pour les services:
 * - charge les entités JPA
 * - charge les services (@Service)
 * - charge les repositories
 * - active la gestion des transactions
 * @author DIGINAMIC
 */
@Configuration
@ComponentScan(basePackages={"dev.paie.service", "dev.paie.util"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories({"dev.paie.repository"})
@EnableTransactionManagement
public class ServicesConfig {
	
}
