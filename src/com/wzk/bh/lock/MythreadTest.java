package com.wzk.bh.lock;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class MythreadTest {
    public static void main(String[] args) {
        Mythread mythread_1=new Mythread();
        Mythread mythread_2=new Mythread();
        Mythread mythread_3=new Mythread();

        mythread_1.setName("one");
        mythread_2.setName("two");
        mythread_3.setName("three");

        mythread_1.start();
        mythread_2.start();
        mythread_3.start();
    }
}
