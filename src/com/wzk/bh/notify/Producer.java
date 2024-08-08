package com.wzk.bh.notify;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Producer extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Controller.lock){
                if (Controller.count==10){
                    break;
                }else {
                    if (Controller.flag==1){
                        try {
                            Controller.lock.wait();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("the cook is cooking the "+(Controller.count+1)+"th noddle");
                        Controller.flag=1;
                        Controller.lock.notifyAll();
                    }
                }
            }
        }
    }
}
