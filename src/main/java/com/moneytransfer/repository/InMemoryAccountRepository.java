package com.moneytransfer.repository;

import com.moneytransfer.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
@Repository
public class InMemoryAccountRepository implements AccountRepository {
    private final Map<Long, Account> storage = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1L);

    @Override
    public Collection<Account> getAll() {
        return storage.values();
    }

    @Override
    public Account getById(Long id) {
        return storage.get(id);
    }

    @Override
    public Account create(String name, BigDecimal amount) {
        var id = idCounter.getAndIncrement();
        var account = new Account(id, name, amount);
        storage.put(id, account);
        return account;
    }

    @Override
    public Account update(Long id, BigDecimal amount) {
        Account account = storage.get(id);
        account.setAmount(amount);
        return account;
    }

}
