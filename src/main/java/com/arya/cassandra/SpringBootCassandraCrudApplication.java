package com.arya.cassandra;

import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.repository.SuperHeroRepository;
import com.arya.cassandra.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;

@SpringBootApplication
@EnableCassandraRepositories("com.arya.cassandra.repository")
public class SpringBootCassandraCrudApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraCrudApplication.class, args);
	}


	@Autowired
	private SuperHeroRepository superHeroRepository;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<SuperHero> superHeroes = superHeroRepository.findAll();
			if (superHeroes.size() == 0) {
				LOGGER.info("******* Inserting Super heroes to DB *******");
				superHeroRepository.saveAll(HelperUtil.superHeroesSupplier.get());
			} else {
				LOGGER.info("******* Super heroes stored in DB Size :: {}", superHeroes.size());
				LOGGER.info("******* Super heroes stored in DB :: {}", superHeroes);
			}
		};
	}

}