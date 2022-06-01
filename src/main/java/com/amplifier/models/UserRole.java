package com.amplifier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data
@ApiModel(value = "UserRole", description = "This model serves as the basic model for all user role entity API operations.")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", value = "An integer value that serves as the unique identifier for any user role entity.", required = true)
    private int id;

    @Column(name = "role", unique = true, nullable = false)
    @ApiModelProperty(name = "userRole", value = "A String value that serves as the user role for the user.", required = true)
    private String role;

    public UserRole() {
    }

    /**
     * @param userRole
     */
    public UserRole(String role) {
        this.role = role;
    }

    public UserRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

}
