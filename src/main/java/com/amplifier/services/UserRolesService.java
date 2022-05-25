package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;

public interface UserRolesService {

    public List<UserRole> getAllUserRoles();

    public UserRole getUserRoleById(int id);

    public boolean addUserRole(UserRole role);

    public boolean editUserRole(UserRole role);

    public boolean deleteUserRole(UserRole role);

}
