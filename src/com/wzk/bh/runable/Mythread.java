package com.wzk.bh.runable;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Mythread implements Runnable{

    @Override
    public void run() {
        Thread thread=Thread.currentThread();
        for (int i = 0; i < 50; i++) {
            System.out.println(thread.getName()+",hello world");
        }
    }
}
