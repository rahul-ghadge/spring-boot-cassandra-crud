package com.arya.cassandra.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;

@Data
@Builder
@UserDefinedType("super_powers")
public class SuperPowers implements Serializable {

    @Column("strength")
    private String strength;
    @Column("durability")
    private String durability;
    @Column("canFly")
    private boolean canFly;
}
