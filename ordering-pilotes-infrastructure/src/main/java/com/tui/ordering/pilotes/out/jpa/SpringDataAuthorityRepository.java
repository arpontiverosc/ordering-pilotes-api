package com.tui.ordering.pilotes.out.jpa;

import com.tui.ordering.pilotes.out.jpa.model.security.AuthorityEntity;
import com.tui.ordering.pilotes.out.jpa.model.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAuthorityRepository extends JpaRepository<AuthorityEntity, String> {

    Optional<AuthorityEntity> findByName(AuthorityName name);

}
