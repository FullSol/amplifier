package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface UserRolesService {

    public List<UserRole> getAll();

    public boolean add(UserRole userRole);

    public UserRole getById(int id);

    public boolean edit(UserRole userRole);

    public boolean remove(int id);

}
