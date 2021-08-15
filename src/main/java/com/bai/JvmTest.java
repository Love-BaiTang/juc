package com.bai;

import java.util.Random;

public class JvmTest {

    public static void main(String[] args) {
//        byte[] bytes = new byte[20*1024*1024];
        String str = "";
        while (true){
            str += str+ new Random().nextInt(88888888)+new Random().nextInt(88888888);
        }
    }

}
