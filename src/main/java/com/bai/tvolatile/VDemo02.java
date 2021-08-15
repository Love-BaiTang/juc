package com.bai.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:liuBai
 * @Time : 2021/8/2 17:35
 *
 * volatile 不保证原子性
 *
 * 禁止指令重拍
 * 指令重拍:
 *  你写的程序，计算机并不是按照你写的那样去执行的。
 *  源代码-->编译器优化的重排-->指令并行也可能重排-->内存系统也会重排-->执行
 *  处理器在进行指令重排的时候，考虑：数据之间的依赖性!
 */
public class VDemo02 {

    //原子类的Integer
    private volatile static AtomicInteger num = new AtomicInteger();

    private static void add(){
        //num++; //不是原子性操作
        num.getAndIncrement();//AtomicInteger + 1 方法，CAS
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 20 ; i++){
            new Thread(()->{
                for (int j = 0 ; j < 1000 ; j++){
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){ //main gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+":"+num);
    }



}
