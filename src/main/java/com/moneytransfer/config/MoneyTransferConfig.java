package com.moneytransfer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitrii Firstov 21/03/2023
 */
@Configuration
@EnableAsync
public class MoneyTransferConfig {
    @Value("${money.transfer.load.factor:1}")
    private int loadFactor;

    @Bean("customThreadPool")
    public Executor customThreadPool() {
        return new ThreadPoolExecutor(1,
                (loadFactor) * Runtime.getRuntime().availableProcessors() * (1 + 1000/40),
                5000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }
}
