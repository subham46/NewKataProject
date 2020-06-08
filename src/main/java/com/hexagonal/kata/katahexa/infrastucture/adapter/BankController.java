package com.hexagonal.kata.katahexa.infrastucture.adapter;

import com.hexagonal.kata.katahexa.domain.port.inport.CreateAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.TransactionInPort;
import com.hexagonal.kata.katahexa.infrastucture.common.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping()
@NoArgsConstructor
public class BankController {

    private CreateAccountPort createAccountPort;

    private TransactionInPort transactionInPort;

    @Autowired
    public BankController(CreateAccountPort createAccountPort, TransactionInPort transactionInPort) {
        this.createAccountPort = createAccountPort;
        this.transactionInPort = transactionInPort;
    }

    @PostMapping("/v.0.1/accounts/new")
    public void createNewAccount(@RequestBody CreateAccountPort.CreateAccountCommand command){
        createAccountPort.create(command);
    }

    @PutMapping(path = "/v.0.1/accounts/{accountId}/deposits")
    public void deposit(@PathVariable(value = "accountId") Long amountId,
                        @RequestParam BigDecimal amount){

        transactionInPort.deposit(amountId,amount);
    }

    @PutMapping(path = "/v.0.1/accounts/{accountId}/withdrawal")
    public void withdrawal(@PathVariable(value = "accountId") long acc_Id,
                            @RequestParam BigDecimal amount){

        transactionInPort.withdraw(acc_Id,amount);
    }

    @GetMapping(path ="/v.0.1/accounts/{accountId}")
    public List<UserTransaction> printHistory(@PathVariable(value = "accountId") Long acc_Id){

        return transactionInPort.print(acc_Id, TransactionType.ALL);

    }

    @GetMapping("print/")
    public String myName(){
        return "My name is shubham";
    }

}
