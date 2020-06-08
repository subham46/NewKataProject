package com.hexagonal.kata.katahexa.infrastucture;

import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserTransaction {

    @Id
    private Long accountId;

    private  Long transId;

    private TransactionType type;

    private LocalDateTime transDate;

    private BigDecimal amount;
}
