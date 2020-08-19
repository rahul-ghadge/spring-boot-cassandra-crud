package com.arya.cassandra.repository;

import com.arya.cassandra.model.SuperHero;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SuperHeroRepository extends CassandraRepository<SuperHero, Serializable> {
}
