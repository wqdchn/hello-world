package thread;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 * @program: hello-world
 * @description: synchronized关键字
 * @author: wqdong
 * @create: 2020-02-22 08:15
 **/

class Timer {

  private static int num = 0;

  public void add(String name) {
    synchronized (this) {
      num++;
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + "：你是第" + num + "个使用timer的线程");
    }
  }
}

public class thread6 implements Runnable {

  Timer timer = new Timer();

  public static void main(String[] args) {
    thread6 t6 = new thread6();

    Thread t1 = new Thread(t6);
    Thread t2 = new Thread(t6);

    t1.setName("线程一");
    t2.setName("线程二");

    t1.start();
    t2.start();

  }

  public void run() {
    timer.add(Thread.currentThread().getName());
  }

}
