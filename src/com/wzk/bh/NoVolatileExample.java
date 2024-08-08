package com.wzk.bh;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class NoVolatileExample {
    private volatile boolean running = true;

    public void start() {
        new Thread(() -> {
            while (running) {
                // Do some work
            }
            System.out.println("Thread stopped.");
        }).start();
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        NoVolatileExample example = new NoVolatileExample();
        example.start();
        Thread.sleep(1000); // Let the thread run for a while
        example.stop();
    }
}
