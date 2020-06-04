package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.DepositInPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class DepositService implements DepositInPort {

    @Autowired
    private LoadAccountPort depositOutPort;

    @Autowired
    private SaveAccountPort createAccountOutPort;



    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        UserAccount account = depositOutPort.getAccount(accountId);
        account.setBalance(account.getBalance().add(amount));
        Account ac = new Account(account.getAccountId(),account.getName(),account.getBalance());
        save(ac,amount, TransactionType.CREDIT);
    }

    public void save(Account account,BigDecimal amount,TransactionType t){

        createAccountOutPort.create(account,amount,t);
    }
}
