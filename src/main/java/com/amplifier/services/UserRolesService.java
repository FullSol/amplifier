package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;

public interface UserRolesService {

    public List<UserRole> getAll();

    public boolean add(UserRole role);

    public UserRole getById(int id);

    public boolean edit(UserRole role);

    public boolean remove(UserRole role);

}
