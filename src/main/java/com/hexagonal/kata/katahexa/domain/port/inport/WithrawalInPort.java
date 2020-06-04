package com.hexagonal.kata.katahexa.domain.port.inport;


import java.math.BigDecimal;

public interface WithrawalInPort {
    public  void withdraw(Long Acc_Id,BigDecimal amount);
}
