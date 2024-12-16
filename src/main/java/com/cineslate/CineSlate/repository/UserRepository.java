package com.cineslate.CineSlate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineslate.CineSlate.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findOneByEmailIgnoreCase(String email);
    User findByUsername(String username);
}
