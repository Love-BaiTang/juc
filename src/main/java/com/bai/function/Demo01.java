package com.bai.function;

import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * @Author:liuBai
 * @Time : 2021/7/23 10:33
 *
 * Function   函数型接口
 *  有一个输入参数，有一个输出参数
 *  是要是函数式接口就可以用lambda表达式简化
 *
 */
public class Demo01 {

    public static void main(String[] args) {
       /*Function function = new Function<String,String>(){

            @Override
            public String apply(String o) {
                return o;
            }
        };*/
        Function function = str->{
            return str;
        };

        System.out.println(function.apply("aaa"));
    }

}
