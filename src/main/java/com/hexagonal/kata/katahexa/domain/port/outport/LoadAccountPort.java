package com.hexagonal.kata.katahexa.domain.port.outport;

import com.hexagonal.kata.katahexa.infrastucture.User;

public interface LoadAccountPort {

     User getAccount(Long acc_Id);
}
