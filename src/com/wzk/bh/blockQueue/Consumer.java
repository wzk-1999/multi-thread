package com.wzk.bh.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Consumer extends Thread{
    private ArrayBlockingQueue<String> arrayBlockingQueue;

    public Consumer(ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                arrayBlockingQueue.take();
                System.out.println("the foodie has got the noddle");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
