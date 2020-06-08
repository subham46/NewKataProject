package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.domain.domainservice.TransactionService;
import com.hexagonal.kata.katahexa.domain.port.inport.TransactionInPort;
import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranServiceConfig {

    @Bean
    TransactionInPort transactionInPort(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort, TransactionOutPort transactionOutPort){
        return new TransactionService(loadAccountPort,saveAccountPort,transactionOutPort);
    }
}
