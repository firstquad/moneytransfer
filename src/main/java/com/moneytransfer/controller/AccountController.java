package com.moneytransfer.controller;

import com.moneytransfer.model.Account;
import com.moneytransfer.service.api.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public Collection<Account> getAll(){
        return accountService.getAll();
    }

    @PostMapping
    public Account create(@RequestParam String name,
                          @RequestParam BigDecimal amount) {
        return accountService.create(name, amount);
    }

}
