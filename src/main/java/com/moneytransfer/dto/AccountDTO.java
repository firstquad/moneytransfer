package com.moneytransfer.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Dmitrii Firstov 21/03/2023
 */
@Data
public class AccountDTO {
    private final long id;
    private final String name;
    private BigDecimal amount;
}
