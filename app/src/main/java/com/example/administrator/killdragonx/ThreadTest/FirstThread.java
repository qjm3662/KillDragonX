package com.example.administrator.killdragonx.ThreadTest;

/**
 * Created by Administrator on 2017/3/25 0025.
 */

public class FirstThread extends Thread{
    private int i;
    @Override
    public void run() {
        for (; i < 20; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        FirstThread f1 = new FirstThread();
        f1.setName("新线程1");
        FirstThread f2 = new FirstThread();
        f2.setName("新线程2");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                f1.start();
                f2.start();
            }
        }
    }
}
