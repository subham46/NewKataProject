package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserAccount;

import java.math.BigDecimal;

public interface UpdateTransaction {

    public void update(UserAccount ua, BigDecimal amount, TransactionType t);
}
