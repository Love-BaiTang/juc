package com.bai.function;

import java.util.function.Predicate;

/**
 * @Author:liuBai
 * @Time : 2021/7/23 10:46
 */
public class Demo02 {
    public static void main(String[] args) {
        /*Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean test(String o) {
                return false;
            }
        };*/
        Predicate<String> predicate = str->{
            if (null==str||"".equals(str)){
                return true;
            }
            return false;
        };

        System.out.println(predicate.test("asda"));
    }

}
