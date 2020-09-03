package com.arya.cassandra.utils;

import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.model.SuperPowers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class HelperUtil {

    private HelperUtil() {
    }

    public static List<SuperHero> getSuperHeroesData() {
        return superHeroesSupplier.get();
    }

    private static final Supplier<List<SuperHero>> superHeroesSupplier = () ->
            Arrays.asList(
                    SuperHero.builder().id(1L).name("Bruce").superName("Hulk").profession("Doctor").age(50)
                            .superPowers(SuperPowers.builder().strength("Body").durability("Week").canFly(false).build()).build(),

                    SuperHero.builder().id(2L).name("Tony").superName("Iron Man").profession("Business man").age(45)
                            .superPowers(SuperPowers.builder().strength("Suit").durability("Month").canFly(true).build()).build(),

                    SuperHero.builder().id(3L).name("Peter").superName("Spider Man").profession("Student").age(21)
                            .superPowers(SuperPowers.builder().strength("Spider sense").durability("Lifelong").canFly(true).build()).build()
            );
}