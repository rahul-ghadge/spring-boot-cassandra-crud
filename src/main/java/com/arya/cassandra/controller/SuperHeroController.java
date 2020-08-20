package com.arya.cassandra.controller;


import com.arya.cassandra.model.SuperHero;
import com.arya.cassandra.service.SuperHeroService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/super-hero")
@Tag(name = "Superhero JPA controller", description = "Superhero CRUD API with documentation annotations")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;



    @Operation(summary = "Get all Superheroes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superheroes list",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SuperHero.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<SuperHero>> findAll() {
        List<SuperHero> list = superHeroService.findAll();
        return ResponseEntity.ok().body(list);
    }




    @Operation(summary = "Get a Superhero by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Superhero",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SuperHero.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Superhero not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> findById(@PathVariable Long id) {
        SuperHero superHero = superHeroService.findById(id);

        if (StringUtils.isEmpty(superHero.getName()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(superHero);
    }




    @Operation(summary = "Create Superhero ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Superhero",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SuperHero.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<SuperHero> save(@Parameter(description = "Superhero object to be created") @RequestBody SuperHero superHero) {
        SuperHero savedSuperHero = superHeroService.save(superHero);
        return ResponseEntity.ok().body(savedSuperHero);
    }



    @Operation(summary = "Update Superhero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update Superhero",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SuperHero.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PutMapping
    public ResponseEntity<SuperHero> update(@Parameter(description = "Superhero object to be updated") @RequestBody SuperHero superHero) {
        SuperHero updatedSuperHero = superHeroService.update(superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }




    @Operation(summary = "Delete the Superhero by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the Superhero",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Parameter(description = "Superhero id to be deleted") @PathVariable Long id) {
        superHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}