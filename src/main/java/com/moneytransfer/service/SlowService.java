package com.moneytransfer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Dmitrii Firstov 21/03/2023
 */
@Service
@Slf4j
public class SlowService {

    @Async("customThreadPool")
    public Future<String> slow() {
        try {
            for (int i = 0; i < 5; i++) {
                log.info("Slow process number {} has started.. Thread name: {}",
                        i,
                        Thread.currentThread().getName());
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new FutureTask<>(() -> "Done");
    }
}
