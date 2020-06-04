package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Transactions;
import com.hexagonal.kata.katahexa.domain.port.inport.PrintHistoryPort;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;

import java.util.List;

public class PrintHistoryService implements PrintHistoryPort {

    @Override
    public List<Transactions> print(Long acc_Id, TransactionType t) {
        return null;
    }
}
