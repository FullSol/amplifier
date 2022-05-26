package com.amplifier.repositories;

import java.util.List;

import com.amplifier.models.UserCharacter;
import com.amplifier.models.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRolesRepository extends JpaRepository<UserRole, Integer> {

  @Query(value = "SELECT * FROM user_roles", nativeQuery = true)
  public List <UserRole> findAll();

  @Query(value = "INSERT INTO user_roles (role) VALUES (?1)", nativeQuery = true)
  public boolean create(String role);

  @Query(value = "SELECT * FROM user_roles WHERE id=?1")
  public UserCharacter findById(int id);

  @Query(value = "UDPATE user_roles SET role=?1 WHERE id = ?2", nativeQuery = true)
  public boolean update(String role, int id);

  @Query(value = "DELETE * FROM user_roles WHERE id=?1", nativeQuery = true)
  public boolean deleteById(int id);

}
