package com.example.administrator.killdragonx.ThreadTest;

import javax.xml.transform.sax.TemplatesHandler;

/**
 * Created by Administrator on 2017/3/25 0025.
 */

public class SecondThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        SecondThread secondThread = new SecondThread();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new Thread(secondThread, "新线程1").start();
                new Thread(secondThread, "新线程2").start();
            }
        }

    }
}
