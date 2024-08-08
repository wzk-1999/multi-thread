package com.wzk.bh;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class LivelockExample {
//    private boolean condition1 = true;
//    private boolean condition2 = false;
//
//    public void method1() {
//        while (condition1) {
//            System.out.println("Thread "+Thread.currentThread().getName()+" is doing...");
//            condition1 = false;
//            condition2 = true;
//        }
//        System.out.println("Thread "+Thread.currentThread().getName()+" finished.");
//    }
//
//    public void method2() {
//        while (condition2) {
//            System.out.println("Thread "+Thread.currentThread().getName()+" is doing...");
//            condition2 = false;
//            condition1 = true;
//        }
//        System.out.println("Thread "+Thread.currentThread().getName()+" finished.");
//    }
//
//    public static void main(String[] args) {
//        LivelockExample example = new LivelockExample();
//        Thread t1 = new Thread(example::method1,"one");
//        Thread t2 = new Thread(example::method2,"two");
//        t1.start();
//        t2.start();
//    }
private boolean condition1 = true;
    private boolean condition2 = true;

    public synchronized void method1() {
        while (condition1) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is attempting to complete its task...");
            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            // If condition2 is true, switch condition1 and condition2
            if (condition2) {
                condition1 = false;  // Change condition1 to avoid deadlock
                condition2 = true;   // Keep condition2 true to allow the other thread to take action
                System.out.println("Thread " + Thread.currentThread().getName() + " changed conditions and yields.");
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
    }

    public synchronized void method2() {
        while (condition2) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is attempting to complete its task...");
            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            // If condition1 is true, switch condition2 and condition1
            if (condition1) {
                condition2 = false;  // Change condition2 to avoid deadlock
                condition1 = true;   // Keep condition1 true to allow the other thread to take action
                System.out.println("Thread " + Thread.currentThread().getName() + " changed conditions and yields.");
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " finished.");
    }

    public static void main(String[] args) {
        LivelockExample example = new LivelockExample();
        Thread t1 = new Thread(example::method1, "one");
        Thread t2 = new Thread(example::method2, "two");
        t1.start();
        t2.start();
    }
}
