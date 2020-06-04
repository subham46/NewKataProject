package com.hexagonal.kata.katahexa.domain.port.inport;

import com.hexagonal.kata.katahexa.domain.domainentity.Transactions;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;

import java.util.List;

public interface PrintHistoryPort {

    List<Transactions> print(Long acc_Id, TransactionType t);
}
