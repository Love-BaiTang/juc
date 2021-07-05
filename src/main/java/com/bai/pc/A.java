package com.bai.pc;

/**
 * 线程之间的通信问题：生产者和消费者,等待唤醒，通知唤醒
 * 线程交替执行  A  B  操作同一个变量 num=0
 * A num+1
 * B num-1
 */
public class A {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i=0; i<10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }

}

//等待，业务，通知
class Data{ //数字资源类
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        if (number!=0){
            this.wait();//等待
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程，我+1完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if (number==0){
            this.wait();//等待
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程，我-1完毕了
        this.notifyAll();
    }


}
