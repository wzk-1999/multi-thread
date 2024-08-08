package com.wzk.ticket;

import javax.swing.*;

/**
 * @author zhankui wang
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
        //using SellTicket01 class, extends Thread

//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        //using SellTicket02 class implements Runable

//        SellTicket02 sellTicket021=new SellTicket02();
//        new Thread(sellTicket021).start();
//        new Thread(sellTicket021).start();
//        new Thread(sellTicket021).start();

        //using SellTicket03 class synchronized method

//     SellTicket03 sellTicket03=new SellTicket03();
//     new Thread(sellTicket03).start();
//     new Thread(sellTicket03).start();
//     new Thread(sellTicket03).start();

        // using SellTicket04 class synchronized code block

        SellTicket04 sellTicket04=new SellTicket04();
        new Thread(sellTicket04).start();
        new Thread(sellTicket04).start();
        new Thread(sellTicket04).start();
    }
}

class SellTicket01 extends Thread {
    private static Integer ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("sells ended");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("window " + Thread.currentThread().getName() + " sold a ticket, have " + ticketNum-- + " tickets left");
        }
    }
}

class SellTicket02 implements Runnable {
    private Integer ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("sells ended");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("window " + Thread.currentThread().getName() + " sold a ticket, have " + ticketNum-- + " tickets left");
        }
    }
}

class SellTicket03 implements Runnable {
    private Integer ticketNum = 100;
    private Boolean loop =true;

    public synchronized void m() {
        if (ticketNum < 0) {
            System.out.println("sells ended");
            loop=false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("window " + Thread.currentThread().getName() + " sold a ticket, have " + ticketNum-- + " tickets left");

    }

    @Override
    public void run() {
        while (loop) {
            m();
        }
    }
}

class SellTicket04 implements Runnable {
        private Integer ticketNum = 100;
        private Boolean loop =true;
        static Object object=new Object();

    public void m() {
        synchronized (/*this*/object){
            if (ticketNum < 0) {
                System.out.println("sells ended");
                loop=false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("window " + Thread.currentThread().getName() + " sold a ticket, have " + ticketNum-- + " tickets left");

        }

    }

    @Override
    public void run() {
        while (loop) {
            m();
        }
    }
}