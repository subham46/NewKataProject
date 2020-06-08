package com.hexagonal.kata.katahexa.infrastucture.adapter;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import com.hexagonal.kata.katahexa.infrastucture.User;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import com.hexagonal.kata.katahexa.infrastucture.repository.KataRepository;
import com.hexagonal.kata.katahexa.infrastucture.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class PersistanceAdapter implements SaveAccountPort, LoadAccountPort, TransactionOutPort {

    private KataRepository kataRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public PersistanceAdapter(KataRepository kataRepository, TransactionRepository transactionRepository) {
        this.kataRepository = kataRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void create(Account a, BigDecimal amount, TransactionType t) {
        User ua = new User();
        ua.setAccountId(a.getAccountId());
        ua.setName(a.getName());
        ua.setBalance(a.getBalance());
        kataRepository.save(ua);

        update(ua,amount,t);
    }

    @Override
    public User getAccount(Long acc_Id) {
        User ua = kataRepository.findById(acc_Id).get();
        return  ua;




    }

    @Override
    public void update(User ua, BigDecimal amount, TransactionType t) {

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
