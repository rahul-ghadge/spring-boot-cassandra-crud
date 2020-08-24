package com.arya.cassandra.repository;

import com.arya.cassandra.model.SuperHero;

import java.util.List;

public interface SuperHeroQueryRepository {

    List<SuperHero> save();

    List<SuperHero> getAll();

    List<SuperHero> getSuperHeroByName(String name);

    SuperHero getOneSuperHeroByName(String name);

    List<SuperHero> getSuperHeroByNameLike(String name);

    SuperHero getSingleSuperHeroBySuperName(String superName);

    List<SuperHero> getSuperHeroByAgeGreaterThan(int age);

    List<SuperHero> getSuperHeroWhoCanFly(boolean canFly);

}
