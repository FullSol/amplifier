package com.amplifier.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "userRole")
@Data
@ApiModel(value = "UserRole", description = "This model serves as the basic model for all user role entity API operations.")

public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(name = "id", notes = "An integer value that serves as the unique identifier for any user role entity.", required = true, value = "1")
    private int id;

    @Column(name = "userRole", unique = true, nullable = false)
    @ApiModelProperty(name = "userRole", notes = "A String value that serves as the user role for the user.", required = true)
    private String userRole;

    public UserRole() {
    }

    /**
     * @param userRole
     */
    public UserRole(String userRole) {
        this.userRole = userRole;
    }

    public UserRole(int id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }

}
