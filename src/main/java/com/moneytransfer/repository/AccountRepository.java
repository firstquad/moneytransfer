package com.moneytransfer.repository;

import com.moneytransfer.model.Account;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
public interface AccountRepository {
    Collection<Account> getAll();
    Account getById(Long id);
    Account create(String name, BigDecimal amount);
    Account update(Long id, BigDecimal amount);
}
