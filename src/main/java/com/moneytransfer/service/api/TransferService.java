package com.moneytransfer.service.api;

import com.moneytransfer.model.Account;
import com.moneytransfer.model.Transaction;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
public interface TransferService {
    Account transfer(Transaction ts);
}
