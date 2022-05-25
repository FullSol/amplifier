package com.amplifier.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_characters")
public class Character {

    private int id;
    private String realm;
    private String name;
}
