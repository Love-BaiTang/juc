package com.bai.pool;

import java.util.concurrent.*;

/**
 * @Author:liuBai
 * @Time : 2021/7/13 15:55
 * Executors工具类、3大方法
 *
 * new ThreadPoolExecutor.AbortPolicy() 会抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()  哪来的会哪去
 * new ThreadPoolExecutor.DiscardPolicy()   丢掉任务，不会抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() 尝试去和最早的竞争,也不会抛出异常
 */
public class Demo01 {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的

        //自定义线程池！
        //最大线程到底该如何定义
        //1、CPU 密集型。 几核，就是几，可以保持cpu的效率最高！System.out.println(Runtime.getRuntime().availableProcessors());
        //2、IO 密集型。判断你的程序中十分耗IO的线程
        //        程序 15个大型任务  io十分占用资源
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i=0;i<10;i++){
                //使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }

}
