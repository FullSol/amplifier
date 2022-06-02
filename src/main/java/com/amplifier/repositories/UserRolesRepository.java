package com.amplifier.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.amplifier.models.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRolesRepository extends JpaRepository<UserRole, Integer> {

  @Query(value = "SELECT * FROM user_roles", nativeQuery = true)
  public List<UserRole> findAll();

  @Query(value = "SELECT * FROM user_roles WHERE id=?1", nativeQuery = true)
  public UserRole findById(int id);

  @Modifying
  @Query(value = "UPDATE user_roles SET role=?1 WHERE id = ?2", nativeQuery = true)
  public boolean update(String role, int id);

  @Modifying
  @Query(value = "DELETE * FROM user_roles WHERE id=?1", nativeQuery = true)
  public boolean delete(int id);

}
