package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.repositories.UserBlizzardAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserBlizzardAccountServiceImpl implements UserBlizzardAccountService {

    @Autowired
    private UserBlizzardAccountRepository repository;

    public boolean add(UserBlizzardAccount account) {
        int pk = repository.save(account).getId();
        return (pk > 0) ? true : false;
    };

    public List<UserBlizzardAccount> getAll() {
        return repository.findAll();
    };

    public UserBlizzardAccount getById(int id) {
        return repository.findById(id);
    };

    public boolean edit(UserBlizzardAccount account) {
        UserBlizzardAccount target = repository.findById(account.getId());

        target.setAccountName(account.getAccountName());

        return (repository.save(target) != null) ? true : false;
    };

    public boolean remove(int id) {
        return repository.delete(id);
    };

}
