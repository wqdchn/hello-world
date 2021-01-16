package basic;

import java.util.*;

/**
 * @program: hello-world
 * @description: 线程，睡眠
 * @author: wqdong
 * @create: 2019-11-07 20:13
 **/
public class basic3_Thread2 {

  public static void main(String args[]) {
    MyThread thread = new MyThread();
    thread.start();//调用start()方法启动新开辟的线程
    try {
      MyThread.sleep(10000);
      System.out.println("主线程睡眠了10秒种后再次启动了");

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.flag = false;//改变循环条件，结束死循环
  }
}

class MyThread extends Thread {

  boolean flag = true;// 定义一个标记，用来控制循环的条件

  public void run() {
    /*
     * 注意：这里不能在run()方法的后面直接写throw Exception来抛异常，
     * 因为现在是要重写从Thread类继承而来的run()方法,重写方法不能抛出比被重写的方法的不同的异常。
     *  所以这里只能写try……catch()来捕获异常
     */
    while (flag) {
      System.out.println("==========" + new Date() + "===========");
      try {
        MyThread.sleep(1000);//睡眠的时如果被打断就会抛出InterruptedException异常
        // 这里是让这个新开辟的线程每隔一秒睡眠一次，然后睡眠一秒钟后再次启动该线程
        // 这里在一个死循环里面每隔一秒启动一次线程，每个一秒打印出当前的系统时间
      } catch (InterruptedException e) {
        return;
      }
    }
  }
}
