package com.masterjavaonline.timetracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@EnableAutoConfiguration
public class EmployeeTimeTrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTimeTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
