package com.moneytransfer.model;

import java.math.BigDecimal;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
public record Transaction(Long fromAccountId,
                          Long toAccountId,
                          BigDecimal amount) {
}
