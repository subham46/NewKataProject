package com.hexagonal.kata.katahexa.domain.port.inport;

import java.math.BigDecimal;

public interface CreateAccountPort {
    void create(CreateAccountCommand Command);

    static class CreateAccountCommand {

        private Long id;
        private String name;
        private BigDecimal balance;

        public CreateAccountCommand(Long id, String name, BigDecimal balance) {
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getBalance() {
            return balance;
        }
    }
}
