package com.amplifier.services;

import java.util.List;

import com.amplifier.models.UserBlizzardAccount;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface UserBlizzardAccountService {

    public boolean add(String userId, UserBlizzardAccount account);

    public List<UserBlizzardAccount> getAll();

    public UserBlizzardAccount getByUserId(String userId);

    public boolean edit(String userId, UserBlizzardAccount account);

    public boolean remove(String battleTag);

}
