package com.wzk.bh.Mythread;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class MythradTest {
    public static void main(String[] args) {
        Thread mythread1=new Mythread();
        Thread mythread2=new Mythread();

        mythread1.setName("thread_1");
        mythread2.setName("thread_2");

        mythread1.start();
        mythread2.start();
    }
}
