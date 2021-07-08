package com.bai.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author:liuBai
 * @Time : 2021/7/8 22:10
 *
 * java.util.ConcurrentModificationException
 *
 * 同理可证:
 * 1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
 * 2、Set<String> set = new CopyOnWriteArraySet<>();
 */
public class SetTest {

    public static void main(String[] args) {
        //Set<String> set = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i=1;i<=50;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }

}
