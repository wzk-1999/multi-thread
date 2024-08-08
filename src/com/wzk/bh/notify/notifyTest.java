package com.wzk.bh.notify;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class notifyTest {
    public static void main(String[] args) {
        Producer producer=new Producer();
        Consumer consumer=new Consumer();

        producer.setName("cooker");
        consumer.setName("foodie");

        producer.start();
        consumer.start();
    }
}
