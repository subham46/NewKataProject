package com.hexagonal.kata.katahexa.bootstrap;

import com.hexagonal.kata.katahexa.domain.domainservice.CreateAccountService;
import com.hexagonal.kata.katahexa.domain.port.inport.CreateAccountPort;
import com.hexagonal.kata.katahexa.domain.port.outport.SaveAccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateServiceConfig {

    @Bean
    CreateAccountPort createAccountPort(SaveAccountPort saveAccountPort){
        return new CreateAccountService(saveAccountPort);
    }
}
