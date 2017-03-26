package com.example.administrator.killdragonx.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/3/26 0026.
 */

public class ThirdThread {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 0;
                for (; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
                return i;
            }
        });

//        try {
//            System.out.println("子线程返回的结果：" + task.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 10){
                new Thread(task, "新线程").start();
            }
        }

        try {
            System.out.println("子线程返回的结果：" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
