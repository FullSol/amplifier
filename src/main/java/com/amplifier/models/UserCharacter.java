package com.amplifier.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_characters")
public class UserCharacter {

    private int id;
    private String realm;
    private String name;

    // Delete this at implementation
    public int getId() {
        return this.id;
    }

    // Delete this at implementation
    public String getName() {
        return this.name;
    }

    // Delete this at implementation
    public String getRealm() {
        return this.realm;
    }
}
