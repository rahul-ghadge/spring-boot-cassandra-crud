package com.arya.cassandra.model;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Builder
@Table("super_hero")
public class SuperHero implements Serializable {

    @PrimaryKey
    private Long id;

    private String name;

    @Column("super_name")
    private String superName;

    private String profession;

    private int age;

    @Column("super_powers")
    private SuperPowers superPowers;

}