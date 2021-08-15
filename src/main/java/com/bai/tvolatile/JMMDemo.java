package com.bai.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author:liuBai
 * @Time : 2021/8/2 17:25
 *
 * 数据可见性
 */
public class JMMDemo {

    private volatile static int number = 0;

    public static void main(String[] args) {//main

        new Thread(()->{ //线程1
            while (number == 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        number = 1;

        System.out.println(number);

    }

}
