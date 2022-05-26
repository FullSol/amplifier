package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;

public interface UserRolesService {

    public List<UserRole> getAll();

    public boolean add(UserRole userRole);

    public UserRole getById(int id);

    public boolean edit(UserRole userRole);

    public boolean remove(int id);

    public UserRole delete(int id);

}
