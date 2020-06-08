package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.domain.port.outport.LoadAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.TransactionOutPort;
import com.hexagonal.kata.katahexa.infrastucture.adapter.PersistanceAdapter;
import com.hexagonal.kata.katahexa.infrastucture.repository.KataRepository;
import com.hexagonal.kata.katahexa.infrastucture.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    @Bean
    SaveAccountPort saveAccountPort(KataRepository kataRepository,TransactionRepository transactionRepository){
        return new PersistanceAdapter(kataRepository,transactionRepository);
    }

    @Bean
    LoadAccountPort loadAccountPort(KataRepository kataRepository, TransactionRepository transactionRepository){
        return new PersistanceAdapter(kataRepository,transactionRepository);
    }


    @Bean
    TransactionOutPort transactionOutPort(KataRepository kataRepository,TransactionRepository transactionRepository){
        return new PersistanceAdapter(kataRepository,transactionRepository);
    }

}


