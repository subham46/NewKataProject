package com.hexagonal.kata.katahexa.infrastucture;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KataRepository extends JpaRepository<UserAccount, Long> {

    @Override
    public <S extends UserAccount> S save(S entity);
}
