package com.hexagonal.kata.katahexa.infrastucture.adapter;

import com.hexagonal.kata.katahexa.domain.port.inport.CreateAccountPort;
import com.hexagonal.kata.katahexa.domain.port.inport.DepositInPort;
import com.hexagonal.kata.katahexa.domain.port.inport.PrintHistoryPort;
import com.hexagonal.kata.katahexa.domain.port.inport.WithrawalInPort;
import com.hexagonal.kata.katahexa.infrastucture.TransactionType;
import com.hexagonal.kata.katahexa.infrastucture.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v.0.1/accounts/")
public class BankController {

    @Autowired
    private CreateAccountPort createAccountPort;

    @Autowired
    private DepositInPort depositInPort;

    @Autowired
    private WithrawalInPort withrawalInPort;

    @Autowired
    private PrintHistoryPort printHistoryPort;


    @PostMapping()
    public void createNewAccount(@RequestBody CreateAccountPort.CreateAccountCommand command){
        createAccountPort.create(command);
    }

    @PutMapping(path = "{accountId}/deposits")
    public void deposit(@PathVariable(value = "accountId") Long amountId,
                        @RequestParam BigDecimal amount){

        depositInPort.deposit(amountId,amount);
    }

    @PutMapping(path = "{accountId}/withdrawal")
    public void withdrawal(@PathVariable(value = "accountId") long acc_Id,
                            @RequestParam BigDecimal amount){

        withrawalInPort.withdraw(acc_Id,amount);
    }

    @GetMapping(path ="{accountId}")
    public List<UserTransaction> printHistory(@PathVariable(value = "accountId") Long acc_Id){

        return printHistoryPort.print(acc_Id, TransactionType.ALL);

    }

}
