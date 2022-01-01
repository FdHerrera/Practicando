package com.herrera.Practicando.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

}