package com.moneytransfer.dto.mapper;

import com.moneytransfer.dto.AccountDTO;
import com.moneytransfer.model.Account;
import org.mapstruct.Mapper;

/**
 * Created by Dmitrii Firstov 21/03/2023
 */
@Mapper
public interface AccountMapper {
    AccountDTO toDto(Account account);
}
