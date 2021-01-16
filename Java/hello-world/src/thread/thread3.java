package thread;

/**
 * @program: hello-world
 * @description: 线程join方法
 * @author: wqdong
 * @create: 2020-02-21 18:19
 **/

class thread3_Thread extends Thread{
  thread3_Thread(String name){
    super(name);
  }

  public void run(){
    for (int i = 0; i < 1000; i++){
      System.out.println("我是" + getName() + " " + i);
      try {
        sleep(10);
      }catch (InterruptedException e){
        return;
      }
    }
  }
}

public class thread3 {

  public static void main(String[] args){
    thread3_Thread thread = new thread3_Thread("一个线程");
    thread.start();

    try {
      thread.join();
    }catch (InterruptedException e){
      e.printStackTrace();
    }

    for (int i = 0; i < 1000; i++){
      System.out.println("我是主线程");
    }

    // 效果就是主线程需要等子线程执行完才执行
  }

}
