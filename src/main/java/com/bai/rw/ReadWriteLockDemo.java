package com.bai.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁(写锁) 一次只能被一个线程占用
 * 共享锁(读锁) 多个线程可以同时占用
 *
 * ReadWriteLock
 *
 * 读 - 读 可以共存
 * 读 - 写 不可共存
 * 写 - 写 不可共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        /*MyCache cache = new MyCache();
        //写入
        for (int i=1 ;i<=6;i++){
            final int temp = i;
            new Thread(()->{cache.put(temp+"",temp+"");},String.valueOf(i)).start();
        }

        //读取
        for (int i=1 ;i<=6;i++){
            final int temp = i;
            new Thread(()->{cache.get(temp+"");},String.valueOf(i)).start();
        }*/

        MyCacheLock myCacheLock = new MyCacheLock();
        for (int i=1 ;i<=6;i++){
            final int temp = i;
            new Thread(()->{myCacheLock.put(temp+"",temp+"");},String.valueOf(i)).start();
        }
        for (int i=1 ;i<=6;i++){
            final int temp = i;
            new Thread(()->{myCacheLock.get(temp+"");},String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    //存 写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完毕");
    }

    //读 取
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完毕");
    }
}


/**
 * 枷锁的
 */
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //存 写
    public void put(String key,Object value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

    //读 取
    public void get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}