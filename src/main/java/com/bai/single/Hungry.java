package com.bai.single;

/**
 * @Author:liuBai
 * @Time : 2021/8/2 18:30
 * 饿汉式单例
 */
public class Hungry {

    public Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }

}
