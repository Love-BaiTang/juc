package com.bai.jvm;

/**
 * @Author:liuBai
 * @Time : 2021/7/14 16:15
 */
public class JVMTest {

    public static void m1(){
        m1();
    }

    //Exception in thread "main" java.lang.StackOverflowError  SOF  栈溢出  错误
    public static void main(String[] args) {
        m1();
    }

}
