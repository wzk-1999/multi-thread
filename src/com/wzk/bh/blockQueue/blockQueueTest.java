package com.wzk.bh.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class blockQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1);

        Consumer consumer=new Consumer(queue);
        Producer producer=new Producer(queue);

        consumer.start();
        producer.start();
    }
}
