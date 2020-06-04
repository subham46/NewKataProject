package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.DepositInPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class DepositService implements DepositInPort {

    @Autowired
    private LoadAccountPort depositOutPort;

    @Autowired
    private SaveAccountPort createAccountOutPort;



    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        Account account = depositOutPort.getAccount(accountId);
        account.setBalance(account.getBalance().add(amount));
        save(account);
    }

    public void save(Account account){
        createAccountOutPort.create(account);
    }
}
