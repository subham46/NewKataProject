package com.hexagonal.kata.katahexa.domain.domainentity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long accountId;

    private String name;

    private BigDecimal balance;


    public void deposit(int amount){

    }



}
