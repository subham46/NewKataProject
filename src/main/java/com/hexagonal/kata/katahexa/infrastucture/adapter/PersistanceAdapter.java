package com.hexagonal.kata.katahexa.infrastucture.adapter;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import com.hexagonal.kata.katahexa.domain.port.outport.UpdateTransaction;
import com.hexagonal.kata.katahexa.infrastucture.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class PersistanceAdapter implements SaveAccountPort, LoadAccountPort, UpdateTransaction, TransactionOutPort {

    @Autowired
    private KataRepository kataRepository;

    @Autowired
    private TransactionRepository transactionRepository;



    @Override
    public void create(Account a, BigDecimal amount, TransactionType t) {
        UserAccount ua = new UserAccount();
        ua.setAccountId(a.getAccountId());
        ua.setName(a.getName());
        ua.setBalance(a.getBalance());
        kataRepository.save(ua);

        update(ua,amount,t);
    }

    @Override
    public Optional<UserAccount> getAccount(Long acc_Id) {
        Optional<UserAccount> ua = kataRepository.findById(acc_Id);
        return  ua;




    }

    @Override
    public void update(UserAccount ua, BigDecimal amount, TransactionType t) {

        UserTransaction ut = new UserTransaction();
        ut.setAccountId(ua.getAccountId());
        ut.setType(t);
        ut.setAmount(amount);
        ut.setTransDate(LocalDateTime.now());

        transactionRepository.save(ut);
    }

    @Override
    public List<UserTransaction> printTransaction(Long acc_Id, TransactionType t) {
        return (List<UserTransaction>) transactionRepository.findAllById(Collections.singleton(acc_Id));
    }
}
