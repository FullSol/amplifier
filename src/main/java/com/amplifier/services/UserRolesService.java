package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;


public interface UserRolesService {
	
    public List<UserRole> getAllUserRoles();

    public boolean createUserRole(UserRole userRole);

    public UserRole getUserRoleById(int Id);

    public boolean updateUserRole(UserRole userRole);

    public boolean deleteUserRoleById(int Id);
	

}
