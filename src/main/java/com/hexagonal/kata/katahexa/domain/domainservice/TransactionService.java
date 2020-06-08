package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.TransactionInPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import com.hexagonal.kata.katahexa.infrastucture.User;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService implements TransactionInPort {

    private LoadAccountPort loadAccountPort;

    private SaveAccountPort createAccountOutPort;

    private TransactionOutPort transactionOutPort;

    public TransactionService(LoadAccountPort depositOutPort, SaveAccountPort createAccountOutPort,TransactionOutPort transactionOutPort) {
        this.loadAccountPort = depositOutPort;
        this.createAccountOutPort = createAccountOutPort;
        this.transactionOutPort = transactionOutPort;
    }

    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        User account = loadAccountPort.getAccount(accountId);
        account.setBalance(account.getBalance().add(amount));
        Account ac = new Account(account.getAccountId(),account.getName(),account.getBalance());
        save(ac,amount, TransactionType.CREDIT);
    }



    @Override
    public void withdraw(Long acc_Id,BigDecimal amount) {



        User ac = loadAccountPort.getAccount(acc_Id);

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





    @Override
    public List<UserTransaction> print(Long acc_Id, TransactionType t) {
        return transactionOutPort.printTransaction(acc_Id,t);
    }


    public void save(Account account,BigDecimal amount,TransactionType t){

        createAccountOutPort.create(account,amount,t);
    }

}
