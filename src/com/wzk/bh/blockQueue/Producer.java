package com.wzk.bh.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Producer extends Thread{
    private ArrayBlockingQueue<String> arrayBlockingQueue;

    public Producer(ArrayBlockingQueue<String> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }
    @Override
    public void run() {
        while (true){
            try {
                arrayBlockingQueue.put("noddle");
                System.out.println("the cooker added a noddle");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
