package thread;

/**
 * @program: hello-world
 * @description: 死锁deadlock
 * @author: wqdong
 * @create: 2020-02-22 08:39
 **/
public class thread7 implements Runnable{

  public int flag = 1;
  static Object o1 = new Object(), o2 = new Object();

  public void run(){

    System.out.println(Thread.currentThread().getName()+"的flag是"+flag);

    if (flag == 1){
      synchronized (o1){
        try {
          Thread.sleep(100);
        }catch (InterruptedException e){
          e.printStackTrace();
        }
        synchronized (o2){
          System.out.println("我想打印111");
        }
      }
    }

    if (flag == 0){
      synchronized (o2){
        try {
          Thread.sleep(100);
        }catch (InterruptedException e){
          e.printStackTrace();
        }
        synchronized (o1){
          System.out.println("我想打印000");
        }
      }
    }

  }

  public static void main(String[] args){

    thread7 td1 = new thread7();
    thread7 td2 = new thread7();

    td1.flag = 0;
    td2.flag = 1;

    Thread t1 = new Thread(td1);
    Thread t2 = new Thread(td2);

    t1.setName("线程一");
    t2.setName("线程二");

    t1.start();
    t2.start();
  }

}
