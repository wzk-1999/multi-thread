package com.wzk.ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class ExecuteExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            System.out.println("Task executed using execute()");
        };

        executorService.execute(task);

        executorService.shutdown();
    }
}
