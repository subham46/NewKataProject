package com.hexagonal.kata.katahexa.domain.domainentity;

import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    private Long accountId;

    private Long transactionId;

    private LocalDateTime transactionDateTime;

    private BigDecimal amount;

    TransactionType type;
}
