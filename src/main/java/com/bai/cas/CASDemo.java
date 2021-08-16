package com.bai.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {



    //cas compareAndSet : 比较斌交换
    // public final boolean compareAndSet(int expect, int update)
    //如果我期望的值达到了，那么就更新，否则，就不跟新
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());
    }

}
