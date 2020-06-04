package com.hexagonal.kata.katahexa.infrastucture;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<UserTransaction, Long> {
}
