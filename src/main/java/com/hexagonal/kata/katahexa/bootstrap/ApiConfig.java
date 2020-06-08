package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.domain.port.inport.CreateAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.TransactionInPort;
import com.hexagonal.kata.katahexa.infrastucture.adapter.BankController;
import lombok.experimental.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    BankController myBean(CreateAccountPort createAccountPort, TransactionInPort transactionInPort){
        return new BankController(createAccountPort, transactionInPort);

    }
}
