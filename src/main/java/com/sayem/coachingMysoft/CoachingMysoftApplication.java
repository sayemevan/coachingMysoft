package com.sayem.coachingMysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class CoachingMysoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachingMysoftApplication.class, args);
	}

}
