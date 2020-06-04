package com.hexagonal.kata.katahexa.domain.port.inport;

import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;

import java.util.List;

public interface PrintHistoryPort {

    List<UserTransaction> print(Long acc_Id, TransactionType t);
}
