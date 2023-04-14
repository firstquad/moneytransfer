package com.moneytransfer.service;

import com.moneytransfer.model.Account;
import com.moneytransfer.model.Transaction;
import com.moneytransfer.service.api.AccountService;
import com.moneytransfer.service.api.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final AccountService accountService;
    @Override
    public Account transfer(Transaction ts) {

        if (ts != null) {
            throw new RuntimeException("test");
        }

        var fromAccount = accountService.getById(ts.fromAccountId());
        var toAccount = accountService.getById(ts.toAccountId());

        var firstLock = fromAccount.getId() > toAccount.getId() ? fromAccount : toAccount;
        var secondLock = fromAccount.getId() < toAccount.getId() ? fromAccount : toAccount;

        synchronized (firstLock) {
            synchronized (secondLock) {
                accountService.update(fromAccount.getId(), fromAccount.getAmount().subtract(ts.amount()));
                accountService.update(toAccount.getId(), toAccount.getAmount().add(ts.amount()));
            }
        }

        return toAccount;
    }
}
