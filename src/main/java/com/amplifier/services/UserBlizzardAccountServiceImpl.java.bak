package com.amplifier.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amplifier.models.User;
import com.amplifier.models.UserBlizzardAccount;
import com.amplifier.repositories.UserBlizzardAccountRepository;
import com.amplifier.repositories.UserRepository;

@Service
@Transactional
public class UserBlizzardAccountServiceImpl implements UserBlizzardAccountService {

    @Autowired
    private UserBlizzardAccountRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean add(String userId, UserBlizzardAccount account) {
        UUID idAsUUID = UUID.fromString(userId);

        User user = userRepository.findById(idAsUUID).get();

        account.setUser(user);

        int pk = repository.save(account).getId();
        return (pk > 0) ? true : false;
    };

    @Override
    public List<UserBlizzardAccount> getAll() {
        return repository.findAll();
    };

    @Override
    public UserBlizzardAccount getByUserId(String userId) {
        UUID userUUID = UUID.fromString(userId);
        return repository.findByUserId(userUUID);
    };

    @Override
    public boolean edit(String userId, UserBlizzardAccount account) {
        UUID idAsUUID = UUID.fromString(userId);
        User user = userRepository.findById(idAsUUID).get();

        UserBlizzardAccount target = repository.findByUserId(idAsUUID);

        target.setBattleTag(account.getBattleTag());

        return (repository.save(target) != null) ? true : false;
    };

    @Override
    public boolean remove(String battleTag) {
        UserBlizzardAccount target = repository.findByBattleTag(battleTag);
        try {
            repository.delete(target.getId());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
