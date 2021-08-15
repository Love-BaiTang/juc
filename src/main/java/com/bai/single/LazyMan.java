package com.bai.single;

/**
 * @Author:liuBai
 * @Time : 2021/8/2 18:32
 * 懒汉式单例
 */
public class LazyMan {

    private LazyMan(){

    }

    private static LazyMan lazyMan;

    private static LazyMan getInstance(){
        if (null == lazyMan){
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }

    //单线程ok

    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++){

        }
    }

}
