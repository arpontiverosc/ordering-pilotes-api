package com.tui.ordering.pilotes.out.jpa;

import com.tui.ordering.pilotes.out.jpa.model.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUserName(String username);
}
