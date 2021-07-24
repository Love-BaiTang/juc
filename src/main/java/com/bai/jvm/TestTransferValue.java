package com.bai.jvm;

/**
 * @Author:liuBai
 * @Time : 2021/7/14 17:18
 */
public class TestTransferValue {

    public void changeValue1(int age){
        System.out.println(age);
        age = 30;
        System.out.println(age);
    }

    public void changeValue2(Person person){
        person.setName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();

        int age = 20 ;
        test.changeValue1(age);
        System.out.println("age----"+age);

        Person person = new Person();
        person.setName("abc");
        test.changeValue2(person);
        System.out.println("personname:"+person.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("str:"+str);
    }

}
