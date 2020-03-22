package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: hello-world
 * @description: 线程池测试1
 * @author: wqdong
 * @create: 2020-03-22 09:44
 **/
public class executor1 {

  public static void executor1() throws InterruptedException {
    ExecutorService es = Executors.newCachedThreadPool();
    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("这是一个线程");
        throw new RuntimeException();
      }
    };

    Thread t1 = new Thread(task);
    t1.start();

    for (int i = 0; i < 5; i++) {
      es.execute(task);
      Thread.sleep(1000);
    }
  }

}
