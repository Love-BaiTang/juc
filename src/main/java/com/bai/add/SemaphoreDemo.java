package com.bai.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数:停车位  限流
        Semaphore semaphore = new Semaphore(3);
        for (int i=0;i<6;i++){
            new Thread(()->{
                //semaphore.acquire();//得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"强到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                //semaphore.release();//释放
            }).start();
        }

    }
}
