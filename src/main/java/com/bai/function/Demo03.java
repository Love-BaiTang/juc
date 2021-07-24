package com.bai.function;

import java.util.function.Consumer;

/**
 * @Author:liuBai
 * @Time : 2021/7/23 10:55
 */
public class Demo03 {

    public static void main(String[] args) {
        /*Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/

        Consumer consumer = str -> {
            System.out.println(str);
        };

        consumer.accept("nihao");
    }

}
