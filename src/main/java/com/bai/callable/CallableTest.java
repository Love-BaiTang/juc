package com.bai.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        //new Thread(new MyThread()).start();
        //new Thread(new FutureTask<>(new MyThread())).start();
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//结果会被缓存，效率高
        Integer integer = null;
        try {
            integer = futureTask.get();//这个get方法 可能会产生阻塞！把他放置在最后
            //或者使用异步通信来处理
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }

}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("call");
        return 1024;
    }
}

/*class MyThread implements Runnable{

    @Override
    public void run() {

    }
}*/
