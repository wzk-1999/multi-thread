package com.wzk.ticket;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class ThreadPoolStateExample {
    public static void main(String[] args) {
//        Callable
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit some tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Initiate an orderly shutdown
        executorService.shutdown();
        System.out.println("Thread pool is shutting down. No new tasks will be accepted.");

        try {
            // Wait for all tasks to finish executing after shutdown
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                // Force shutdown if tasks are not finished within the timeout
                executorService.shutdownNow();
                System.out.println("Thread pool forced shutdown. Terminated unfinished tasks.");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Thread pool terminated.");
    }
}
