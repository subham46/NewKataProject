package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.infrastucture.User;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionOutPort {

    List<UserTransaction> printTransaction(Long acc_Id, TransactionType t);

    public void update(User ua, BigDecimal amount, TransactionType t);
}
