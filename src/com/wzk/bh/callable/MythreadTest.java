package com.wzk.bh.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class MythreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mythread mythread=new Mythread();
        FutureTask<Integer> futureTask=new FutureTask<>(mythread);

        Thread t1=new Thread(futureTask);
        t1.start();
        System.out.println(futureTask.get());

    }
}
