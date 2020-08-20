package com.arya.cassandra.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;

@Data
@Builder
@UserDefinedType("super_powers")
public class SuperPowers implements Serializable {

    private String strength;

    private String durability;

    private boolean canFly;
}
