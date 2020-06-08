package com.hexagonal.kata.katahexa.domain.domainservice;

import com.hexagonal.kata.katahexa.domain.domainentity.Account;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.CreateAccountPort;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService implements CreateAccountPort {

    private SaveAccountPort createAccountOutPort;

    public CreateAccountService(SaveAccountPort saveAccountPort) {
        this.createAccountOutPort = saveAccountPort;
    }

    @Override
    public void create(CreateAccountCommand command) {
        Account ac = new Account(command.getId(), command.getName(), command.getBalance());

        createAccountOutPort.create(ac, ac.getBalance(),TransactionType.CREDIT);
    }


}
