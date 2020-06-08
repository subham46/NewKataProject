package com.hexagonal.kata.katahexa.infrastucture.repository;

import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<UserTransaction, Long> {
}
