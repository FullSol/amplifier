package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserBlizzardAccount;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserBlizzardAccountService {

    public boolean add(UserBlizzardAccount account);

    public List<UserBlizzardAccount> getAll();

    public UserBlizzardAccount getById(int id);

    public boolean edit(UserBlizzardAccount account);

    public boolean remove(int id);

}
