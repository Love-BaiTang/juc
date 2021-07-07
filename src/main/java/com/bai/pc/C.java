package com.bai.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther liuBai
 * A 执行完调用B B执行完调用C
 */
public class C {

    public static void main(String[] args) {
        DataC dataC = new DataC();
        new Thread(()->{for (int i=0;i<10;i++) dataC.printA();},"A").start();
        new Thread(()->{for (int i=0;i<10;i++) dataC.printB();},"B").start();
        new Thread(()->{for (int i=0;i<10;i++) dataC.printC();},"C").start();
    }

}

class DataC{

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private Integer number = 1;//1A 2B 3C

    public void printA(){
        lock.lock();
        try {
            //业务，判断-》执行-》通知
            while (number!=1){
                conditionA.await();//等待
            }
            System.out.println(Thread.currentThread().getName()+"=>AAA");
            //唤醒，唤醒指定的人B
            number = 2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            //业务，判断-》执行-》通知
            while (number!=2){
                conditionB.await();//等待
            }
            //唤醒，唤醒指定的人C
            System.out.println(Thread.currentThread().getName()+"=>BBBBB");
            number = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            //业务，判断-》执行-》通知
            while (number != 3){
                conditionC.await();//等待
            }
            //唤醒，唤醒指定的人A
            System.out.println(Thread.currentThread().getName()+"=>CCCCCC");
            number = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
