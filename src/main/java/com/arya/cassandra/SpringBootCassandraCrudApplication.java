package com.arya.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class SpringBootCassandraCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraCrudApplication.class, args);
	}

}
