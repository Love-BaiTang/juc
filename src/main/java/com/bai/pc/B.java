package com.bai.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B {

    public static void main(String[] args) {
        DataB dataB = new DataB();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"E").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    dataB.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"F").start();
    }

}

//等待，业务，通知
class DataB{ //数字资源类
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0){ //此处不要用if  防止虚假唤醒
                condition.await();//等待
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程，我+1完毕了
            condition.signalAll();
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            while (number==0){ //此处不要用if  防止虚假唤醒
                condition.await();//等待
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程，我-1完毕了
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
