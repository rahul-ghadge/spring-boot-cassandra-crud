package com.arya.cassandra.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@Builder
@UserDefinedType("super_powers")
public class SuperPowers implements Serializable {

    @Column
    private String strength;
    @Column
    private String durability;
    @Column
    private boolean canFly;
}
