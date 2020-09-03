package com.arya.cassandra.controller;


import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.service.SuperHeroQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/super-heroes-query")
@Tag(name = "Superhero Query controller", description = "Get Superhero APIs using Queries")
public class SuperHeroQueryController {

    @Autowired
    private SuperHeroQueryService superHeroQueryService;


    @Operation(summary = "Get all Superheroes using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superheroes list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public List<SuperHero> getAll() {
        return superHeroQueryService.getAll();
    }


    @Operation(summary = "Get all Superheroes by name using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superheroes list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/name/{name}")
    public List<SuperHero> getSuperHeroByName(@Parameter(description = "Superhero name to be fetched") @PathVariable String name) {
        return superHeroQueryService.getSuperHeroByName(name);
    }


    @Operation(summary = "Get one Superhero by name using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get one Superhero by name",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SuperHero.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/one-by-name/{name}")
    public SuperHero getOneSuperHeroByName(@Parameter(description = "Superhero name to be fetched") @PathVariable String name) {
        return superHeroQueryService.getOneSuperHeroByName(name);
    }

    @Operation(summary = "Get one Superhero by name like using query (Only on indexed columns)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get one Superhero by name like",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/name-like/{name}")
    public List<SuperHero> getSuperHeroByNameLike(@Parameter(description = "Superhero name to be fetched") @PathVariable String name) {
        return superHeroQueryService.getSuperHeroByNameLike(name);
    }


    @Operation(summary = "Get one Superhero by super name using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get one Superhero by super name",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SuperHero.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/one-by-superName/{superName}")
    public SuperHero getSingleSuperHeroBySuperName(@Parameter(description = "Superhero super name to be fetched") @PathVariable String superName) {
        return superHeroQueryService.getSingleSuperHeroBySuperName(superName);
    }


    @Operation(summary = "Get all Superheroes whose age greater than using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superheroes list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/age-greater-than/{age}")
    public List<SuperHero> getSuperHeroByAgeGreaterThan(@Parameter(description = "Superheroes fetched whose age greater than") @PathVariable int age) {
        return superHeroQueryService.getSuperHeroByAgeGreaterThan(age);
    }

    @Operation(summary = "Get all Superhero who can or can not fly using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superheroes list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/can-fly/{canFly}")
    public List<SuperHero> getSuperHeroWhoCanFly(@Parameter(description = "Superhero who can or can not fly to be fetched") @PathVariable boolean canFly) {
        return superHeroQueryService.getSuperHeroWhoCanFly(canFly);
    }
}
