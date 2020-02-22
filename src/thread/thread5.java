package thread;

/**
 * @program: hello-world
 * @description: 线程优先级
 * @author: wqdong
 * @create: 2020-02-22 08:04
 **/

class thread5_Thread1 implements Runnable {

  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("线程一" + i);
    }
  }
}

class thread5_Thread2 implements Runnable {

  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("线程二" + i);
    }
  }
}

public class thread5 {

  public static void main(String[] args) {
    thread5_Thread1 r1 = new thread5_Thread1();
    thread5_Thread2 r2 = new thread5_Thread2();

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.setPriority(Thread.NORM_PRIORITY - 2);

    t1.start();
    t2.start();

    for (int i = 0; i < 1000; i++) {
      System.out.println("线程一优先级是" + t1.getPriority());
    }

  }

}
