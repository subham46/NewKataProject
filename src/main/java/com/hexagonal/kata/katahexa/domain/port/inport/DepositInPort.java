package com.hexagonal.kata.katahexa.domain.port.inport;

import java.math.BigDecimal;

public interface DepositInPort {
    public void deposit(Long accountId, BigDecimal amount);
}
