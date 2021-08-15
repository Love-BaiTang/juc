package com.bai.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();
        //test2();
        test3();
    }

    //普通程序员
    public static Long test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i<= 10_0000_0000 ; i++){
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));
        return sum;
    }

    //会使用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long aLong = submit.get();
        //forkJoinPool.execute(task);//提交任务
        long end = System.currentTimeMillis();
        System.out.println("sum="+aLong+"时间："+(end-start));
    }

    //并行流
    public static void test3(){
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L,10_0000_0000).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));
    }
}
