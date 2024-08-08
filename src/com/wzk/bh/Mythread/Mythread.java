package com.wzk.bh.Mythread;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Mythread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+ ",hello world");
        }

    }
}
