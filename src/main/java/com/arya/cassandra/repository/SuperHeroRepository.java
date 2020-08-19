package com.arya.cassandra.repository;

import com.arya.cassandra.model.SuperHero;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SuperHeroRepository extends CassandraRepository<SuperHero, String> {
}
