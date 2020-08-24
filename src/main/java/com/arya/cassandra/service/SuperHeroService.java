package com.arya.cassandra.service;


import com.arya.cassandra.model.SuperHero;

import java.util.List;

public interface SuperHeroService {

    List<SuperHero> save();

    List<SuperHero> findAll();

    SuperHero findById(Long id);

    SuperHero save(SuperHero superHero);

    SuperHero update(SuperHero superHero);

    void delete(Long id);

}