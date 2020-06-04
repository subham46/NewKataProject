package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.infrastucture.UserAccount;

import java.util.Optional;

public interface LoadAccountPort {

     UserAccount getAccount(Long acc_Id);
}
