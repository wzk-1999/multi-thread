package com.wzk.bh;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class ThreadLocalExample {
    // Create a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = threadLocalValue.get();
            System.out.println(Thread.currentThread().getName() + " initial value: " + value);
            threadLocalValue.set(value + 1);
            System.out.println(Thread.currentThread().getName() + " updated value: " + threadLocalValue.get());
        };

        // Start two threads
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
