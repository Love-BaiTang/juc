package com.bai.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SeleTicketDemo02 {

    public static void main(String[] args) {
        //多线程操作
        //并发：对线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        new Thread(()->{ for (int i=0; i<60; i++) ticket.sale(); },"A").start();
        new Thread(()->{ for (int i=0; i<60; i++) ticket.sale(); },"B").start();
        new Thread(()->{ for (int i=0; i<60; i++) ticket.sale(); },"C").start();
    }

}

//lock三部曲
//1、new ReentrantLock()
//2、lock.lock() //加锁
//3、finally=>lock.unlock(); //解锁
class Ticket2{
    //属性、方法
    private int number = 50;

    private Lock lock = new ReentrantLock();

    //买票的方法
    public synchronized void sale(){
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票,剩余："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}