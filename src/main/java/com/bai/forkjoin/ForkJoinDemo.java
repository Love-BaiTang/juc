package com.bai.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author:liuBai
 * @Time : 2021/7/23 14:09
 *
 * 求和计算的任务！
 *如何使用forkjoin
 * 1、forkjoinPool通过他来执行
 * 2、计算任务forkjoinPool.execute(ForkJoinTask task)
 *
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;

    public ForkJoinDemo(long start,long end){
        this.start = start;
        this.end = end;
    }

    //临界值
    private long temp = 10000L;

    public static void main(String[] args) {

        //3000
        int sum = 0;
        for (int i=1 ; i<=10_0000_0000; i++){
            sum+=i;
        }
        //6000(Forkjoin)
        //9000(Stream并行流)
        System.out.println(sum);
    }


    //计算方法
    @Override
    protected Long compute() {
        if ((end-start)<temp){
            long sum = 0;
            for (long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{//forkjoin
            long middle = (end+start)/2; //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();//拆分任务，把任务压入线程队列
            long result = task1.join() + task2.join();
            return result;
        }
        //return null;
    }
}
