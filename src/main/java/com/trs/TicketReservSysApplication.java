package com.trs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan("com.trs")
public class TicketReservSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketReservSysApplication.class, args);
	}

}
