package com.wzk.bh.callable;

import java.util.concurrent.Callable;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class Mythread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer sum=0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
