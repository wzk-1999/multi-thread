package com.wzk.ticket;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class NotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 waiting...");
                    lock.wait();
                    System.out.println("Thread 1 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 2 waiting...");
                    lock.wait();
                    System.out.println("Thread 2 resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);

        synchronized (lock) {
            // Uncomment one of the following lines to see the difference:
            lock.notify();
//            lock.notifyAll();
        }
    }
}
