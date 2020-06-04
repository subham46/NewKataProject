package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.port.inport.PrintHistoryPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PrintHistoryService implements PrintHistoryPort {

    @Autowired
    private TransactionOutPort transactionOutPort;

    @Override
    public List<UserTransaction> print(Long acc_Id, TransactionType t) {
        return transactionOutPort.printTransaction(acc_Id,t);
    }
}
