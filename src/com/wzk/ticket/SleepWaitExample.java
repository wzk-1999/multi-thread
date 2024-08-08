package com.wzk.ticket;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class SleepWaitExample {
    public static void main(String[] args) {
        // Example using sleep()
        Thread sleepThread = new Thread(() -> {
            try {
                System.out.println("Sleep thread: Sleeping for 2 seconds...");
                Thread.sleep(2000); // Sleep for 2 seconds
                System.out.println("Sleep thread: Woke up after 2 seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Example using wait()
        Object lock = new Object();
        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Wait thread: Waiting for notification...");
                    lock.wait(); // Wait for notification
                    System.out.println("Wait thread: Notified and proceeding");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sleepThread.start();
        waitThread.start();

        try {
            // Main thread sleeps for 1 second before notifying the waitThread
            Thread.sleep(1000);
            synchronized (lock) {
                System.out.println("Main thread: Notifying wait thread...");
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
