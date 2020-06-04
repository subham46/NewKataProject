package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;

import java.util.List;

public interface TransactionOutPort {

    List<UserTransaction> printTransaction(Long acc_Id, TransactionType t);
}
