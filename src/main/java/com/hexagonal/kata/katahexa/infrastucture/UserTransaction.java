package com.hexagonal.kata.katahexa.infrastucture;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserTransaction {

    private Long accountId;

    private  Long transId;

    private TransactionType type;

    private LocalDateTime transDate;

    private BigDecimal amount;
}
