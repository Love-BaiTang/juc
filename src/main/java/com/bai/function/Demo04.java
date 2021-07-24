package com.bai.function;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @Author:liuBai
 * @Time : 2021/7/23 10:59
 */
public class Demo04 {

    public static void main(String[] args) {
        /*Supplier<String> supplier = new Supplier<String>() {

            @Override
            public String get() {
                return "1024";
            }
        };*/
        Supplier<String> supplier = () -> {
            return "1024";
        };

        System.out.println(supplier.get());
    }

}
