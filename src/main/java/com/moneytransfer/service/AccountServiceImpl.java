package com.moneytransfer.service;

import com.moneytransfer.model.Account;
import com.moneytransfer.repository.AccountRepository;
import com.moneytransfer.service.api.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    private final SlowService slowService;

    @Override
    public Collection<Account> getAll() {
        Future<String> slow = slowService.slow();
        if (slow.isDone()) {
            try {
                slow.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
            }
        }
        return repository.getAll();
    }

    @Override
    public Account getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Account create(String name, BigDecimal amount) {
        return repository.create(name, amount);
    }

    @Override
    public Account update(Long id, BigDecimal amount) {
        return repository.update(id, amount);
    }


}
