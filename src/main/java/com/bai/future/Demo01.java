package com.bai.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用:Ajax
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求
        //没有返回值的异步回调
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
        });
        System.out.println("1111");
        completableFuture.get();//获取阻塞执行结果*/

        //有返回值的supplyAsync 异步回调
        //ajax  的成功和失败回调
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
            return 9/0;
        });

        completableFuture1.whenComplete((t,u)->{
            System.out.println("t=>"+t);
            System.out.println("t=>"+u);
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;
        }).get();
    }

}
