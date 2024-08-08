package com.wzk.bh.runable;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class MythreadTest {
    public static void main(String[] args) {
        Mythread mythread=new Mythread();

        Thread thread1=new Thread(mythread);
        Thread thread2=new Thread(mythread);

        thread1.start();
        thread2.start();
    }
}
