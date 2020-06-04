package com.hexagonal.kata.katahexa.infrastucture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
public class UserAccount {
    @Id
    private Long accountId;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "Account_Balance")
    private BigDecimal balance;
}
