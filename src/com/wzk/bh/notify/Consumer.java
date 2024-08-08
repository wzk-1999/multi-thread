package com.wzk.bh.notify;

import static com.wzk.bh.notify.Controller.lock;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Consumer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if(Controller.count==10){
                    break;
                }else {
                    if(Controller.flag==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        Controller.count++;
                        System.out.println("the foodie is eating..., and this is the "+Controller.count+"th bowl");
                        Controller.flag=0;
                        Controller.lock.notifyAll();


                    }
                }
            }
        }
    }
}
