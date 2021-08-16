package com.bai.single;

/**
 * @Author:liuBai
 * @Time : 2021/8/2 18:32
 * 懒汉式单例
 */
public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private volatile static LazyMan lazyMan;
    //双重检测所模式的 懒汉式单例 DCL懒汉式
    private static LazyMan getInstance(){
        if (null == lazyMan){
            synchronized (LazyMan.class){
                lazyMan = new LazyMan();//不是原子性操作
                /**
                 * 1.分配内存空间
                 * 2.执行构造方法初始化对象
                 * 3.把对象指向这个空间
                 */
            }
        }
        return lazyMan;
    }

    //单线程ok

    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++){
            new Thread(()->{
                LazyMan instance = LazyMan.getInstance();
            }).start();
        }
    }

}
