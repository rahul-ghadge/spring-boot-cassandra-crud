package com.arya.cassandra.controller;


import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.service.SuperHeroQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/super-hero-query")
@Tag(name = "Superhero Query controller", description = "Superhero CRUD API with documentation annotations")
public class SuperHeroQueryController {

    @Autowired
    private SuperHeroQueryService superHeroQueryService;

    @GetMapping
    public List<SuperHero> getAll() {
        return superHeroQueryService.getAll();
    }


    // getAll SuperHero by name (equals())
    @GetMapping("/name/{name}")
    public List<SuperHero> getSuperHeroByName(@PathVariable String name) {
        return superHeroQueryService.getSuperHeroByName(name);
    }


    // getAll SuperHero by name (equals())
    @GetMapping("/one-by-name/{name}")
    public SuperHero getOneSuperHeroByName(@PathVariable String name) {
        return superHeroQueryService.getOneSuperHeroByName(name);
    }

    // getAll SuperHero by name %LIKE%
    @GetMapping("/name-like/{name}")
    public List<SuperHero> getSuperHeroByNameLike(@PathVariable String name) {
        return superHeroQueryService.getSuperHeroByNameLike(name);
    }


    // getAll SuperHero by super name (equals())
    @GetMapping("/one-by-superName/{superName}")
    public SuperHero getSingleSuperHeroBySuperName(@PathVariable String superName) {
        return superHeroQueryService.getSingleSuperHeroBySuperName(superName);
    }


    @GetMapping("/age-greater-than/{age}")
    public List<SuperHero> getSuperHeroByAgeGreaterThan(@PathVariable int age) {
        return superHeroQueryService.getSuperHeroByAgeGreaterThan(age);
    }


    @GetMapping("/can-fly/{canFly}")
    public List<SuperHero> getSuperHeroWhoCanFly(@PathVariable boolean canFly) {
        return superHeroQueryService.getSuperHeroWhoCanFly(canFly);
    }
}
