package basic;

/**
 * @program: hello-world
 * @description: 线程
 * @author: wqdong
 * @create: 2019-11-07 18:16
 **/
public class basic2_Thread1 {

  public static void main(String args[]) {
    Runner1 r1 = new Runner1();//这里new了一个线程类的对象出来
    Runner2 r2 = new Runner2();

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    r1.run();//这个称为方法调用，方法调用的执行是等run()方法执行完之后才会继续执行main()
    r2.run();

    t1.start();//启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行
    t2.start();

    for (int i = 0; i < 5; i++) {
      System.out.println("maintheod：" + i);
    }
  }
}

/*定义一个类用来实现Runnable接口，实现Runnable接口就表示这个类是一个线程类*/
class Runner1 implements Runnable {

  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Runner1：" + i);
    }

  }
}

/*Runner2类从Thread类继承*/
class Runner2 extends Thread {

  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Runner2：" + i);
    }

  }
}