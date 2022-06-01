package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserRole;
import com.amplifier.repositories.UserRolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesRepository repository;

    public UserRolesServiceImpl(UserRolesRepository repo) {
    }

    @Override
    public boolean add(UserRole userRole) {
        int pk = repository.save(userRole).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public UserRole getById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<UserRole> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean edit(UserRole userRole) {
        UserRole target = repository.findById(userRole.getId());
        target.setUserRole(userRole.getUserRole());
        return (repository.save(target) != null) ? true : false;
    }

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }

}
