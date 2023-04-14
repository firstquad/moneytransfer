package com.moneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Dmitrii Firstov 15/03/2023
 */
@Data
@AllArgsConstructor
public class Account {
    private final long id;
    private final String name;
    private BigDecimal amount;
}
