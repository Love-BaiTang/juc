package com.bai.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java.util.ConcurrentModificationException
 */
public class MapTest {

    public static void main(String[] args) {
        //map是这样用的么？ 不是，工作中不用HashMap
        // 默认等价于什么  new HashMap<String,String>(16,0.75f);
        //Map<String,String> map = new HashMap<String,String>(16,0.75f);
        //加载因子、初始化容量

        //1.Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        //2.Map<String,String> map = new ConcurrentHashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i=1;i<=30;i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

}
