package com.industri.home.repository;

import com.industri.home.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Transactional
    Optional<User> findByNama(String nama);

    boolean existsByEmail(String email);
}
