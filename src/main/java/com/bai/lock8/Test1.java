package com.bai.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author:liuBai
 * @Time : 2021/7/8 21:13
 * 8锁，就是关于锁的8个问题
 * 1、标准情况下，两个线程先打印 发短信还是 打电话？1/发短信 2/打电话
 */
public class Test1 {

    public static void main(String[] args) {
        Phone p = new Phone();
        new Thread(()->{
            p.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            p.call();
        },"B").start();
    }

}

class Phone{

    public synchronized void sendSms(){
        System.out.println("sendSms");
    }

    public synchronized void call(){
        System.out.println("call");
    }

}
