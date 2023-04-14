package com.moneytransfer.controller;

import com.moneytransfer.model.Account;
import com.moneytransfer.model.Transaction;
import com.moneytransfer.service.api.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by Dmitrii Firstov 16/03/2023
 */
@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/{fromId}/{toId}/{amount}")
    public Account transfer(@PathVariable Long fromId,
                            @PathVariable Long toId,
                            @PathVariable BigDecimal amount) {
        return transferService.transfer(new Transaction(fromId, toId, amount));
    }

}
