package com.trs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan
public class TicketReservSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketReservSysApplication.class, args);
	}

}
