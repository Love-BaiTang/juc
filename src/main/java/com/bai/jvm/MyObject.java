package com.bai.jvm;

/**
 * @Author:liuBai
 * @Time : 2021/7/14 11:36
 */
public class MyObject {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());
        System.out.println(object.getClass().getClassLoader().getParent());
        System.out.println(object.getClass().getClassLoader().getParent().getParent());

        System.out.println();

        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
    }

}
