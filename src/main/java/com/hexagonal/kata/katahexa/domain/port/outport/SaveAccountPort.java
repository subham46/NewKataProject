package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;

import java.math.BigDecimal;

public interface SaveAccountPort {
    void create(Account a, BigDecimal amount, TransactionType T);
}
