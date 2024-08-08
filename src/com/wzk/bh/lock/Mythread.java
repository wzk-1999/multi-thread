package com.wzk.bh.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Mythread extends Thread {
    static int ticket=0;
    static Lock lock =new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticket==100){
                    break;
                }else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName()+",selling the "+"ticket "+ticket);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
