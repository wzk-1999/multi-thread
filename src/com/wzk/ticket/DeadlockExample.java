package com.wzk.ticket;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class DeadlockExample {
    static class Resource {
        private final String name;

        Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        final Resource resource1 = new Resource("Resource1");
        final Resource resource2 = new Resource("Resource2");

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked " + resource1.getName());
                try {
                    // Simulating some work with resource1
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked " + resource2.getName());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked " + resource2.getName());
                try {
                    // Simulating some work with resource2
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked " + resource1.getName());
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
