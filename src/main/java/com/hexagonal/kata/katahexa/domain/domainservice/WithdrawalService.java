package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.WithrawalInPort;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

public class WithdrawalService implements WithrawalInPort {

    @Autowired
    private LoadAccountPort loadAccountPort;

    @Autowired
    private SaveAccountPort saveAccountPort;

    @Override
    public void withdraw(Long acc_Id,BigDecimal amount) {



        UserAccount ac = loadAccountPort.getAccount(acc_Id);

        validateAmount(ac.getBalance(),amount);

        ac.setBalance(ac.getBalance().subtract(amount));
        Account account = new Account(ac.getAccountId(),ac.getName(),ac.getBalance());

        save(account,amount,TransactionType.DEBIT);
    }

    public boolean validateAmount(BigDecimal balance, BigDecimal amount){
        if(balance.compareTo(amount) < 0)
            return false;
        else return true;
    }

    public void save(Account ac, BigDecimal amount, TransactionType t){
        saveAccountPort.create(ac,amount,t);
    }
}
