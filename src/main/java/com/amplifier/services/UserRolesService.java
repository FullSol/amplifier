package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;


public interface UserRolesService {
	
    public List<UserRole> getAll();

    public boolean add(UserRole userRole);

    public UserRole getById(int Id);

    public boolean edit(UserRole userRole);

    public boolean remove(int Id);

	boolean isValidUserRoleViolated(Integer id, String role);

	static Object deleteUserRole(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
