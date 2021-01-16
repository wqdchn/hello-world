package thread;

/**
 * @program: hello-world
 * @description: 线程yield方法
 * @author: wqdong
 * @create: 2020-02-21 18:40
 **/

class thread4_Thread extends Thread {

  thread4_Thread(String name) {
    super(name);
  }

  public void run() {

    for (int i = 0; i < 1000; i++) {
      System.out.println("我是" + getName() + " " + i);
      if (i % 2 == 0) {
        yield();

/*       在程序的运行的过程中可以看到，
         线程t1执行到(i%2==0)次时就会让出线程让t2线程来优先执行
         而线程t2执行到(i%2==0)次时也会让出线程给t1线程优先执行*/

      }
    }
  }

}

public class thread4 {

  public static void main(String[] args) {
    thread4_Thread t1 = new thread4_Thread("线程一");
    thread4_Thread t2 = new thread4_Thread("线程二");

    t1.start();
    t2.start();

    for (int i = 0; i < 10000; i++) {
      System.out.println("我是主线程");
    }


/*  我是主线程
    我是线程一 21
    我是线程二 16
    我是线程一 22
    我是主线程*/
  }

}
