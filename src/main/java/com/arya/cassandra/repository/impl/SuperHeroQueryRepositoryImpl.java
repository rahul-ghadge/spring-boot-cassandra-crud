package com.arya.cassandra.repository.impl;

import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.repository.SuperHeroQueryRepository;
import com.arya.cassandra.utils.HelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SuperHeroQueryRepositoryImpl implements SuperHeroQueryRepository {

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public List<SuperHero> save() {
        List<SuperHero> superHeroes = cassandraTemplate.select(Query.empty(), SuperHero.class);
        if (superHeroes.isEmpty())
            cassandraTemplate.insert(HelperUtil.getSuperHeroesData());

        return cassandraTemplate.select(Query.empty(), SuperHero.class);
    }

    @Override
    public List<SuperHero> getAll() {
        return cassandraTemplate.select(Query.empty(), SuperHero.class);
    }

    @Override
    public List<SuperHero> getSuperHeroByName(String name) {
        return cassandraTemplate.select(Query.query(Criteria.where("name").is(name)).withAllowFiltering(), SuperHero.class);
    }

    @Override
    public SuperHero getOneSuperHeroByName(String name) {
        return cassandraTemplate.selectOne(Query.query(Criteria.where("name").is(name)).withAllowFiltering(), SuperHero.class);
    }

    @Override
    public List<SuperHero> getSuperHeroByNameLike(String name) {
        return cassandraTemplate.select(Query.query(Criteria.where("name").like(name)).withAllowFiltering(), SuperHero.class);
    }

    @Override
    public SuperHero getSingleSuperHeroBySuperName(String superName) {
        return cassandraTemplate.selectOne(Query.query(Criteria.where("super_name").is(superName)).withAllowFiltering(), SuperHero.class);
    }

    @Override
    public List<SuperHero> getSuperHeroByAgeGreaterThan(int age) {
        return cassandraTemplate.select(Query.query(Criteria.where("age").gt(age)).withAllowFiltering(), SuperHero.class);
    }

    @Override
    public List<SuperHero> getSuperHeroWhoCanFly(boolean canFly) {
        List<SuperHero> superHeroList = cassandraTemplate.select(Query.empty(), SuperHero.class);
        return superHeroList.stream().filter(superHero -> superHero.getSuperPowers().isCanFly() == canFly).collect(Collectors.toList());
    }
}
