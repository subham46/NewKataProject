package com.hexagonal.kata.katahexa.domain.port.inport;

import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionInPort {
    public void deposit(Long accountId, BigDecimal amount);

    public  void withdraw(Long Acc_Id,BigDecimal amount);

    List<UserTransaction> print(Long acc_Id, TransactionType t);


}
