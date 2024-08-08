package com.wzk.ticket;

import java.util.concurrent.*;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class SubmitExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Using submit() with Runnable
        Runnable task1 = () -> {
            System.out.println("Task executed using submit() with Runnable");
        };
        Future<?> future1 = executorService.submit(task1);

        // Using submit() with Callable
        Callable<String> task2 = () -> {
            return "Result from submit() with Callable";
        };
        Future<String> future2 = executorService.submit(task2);

        try {
            // Wait for the completion of the tasks and get results
            future1.get(); // This will return null since the task is Runnable
            String result = future2.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
