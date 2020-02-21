package thread;

/**
 * @program: hello-world
 * @description: 使用实现Runnable接口创建和启动线程
 * @author: wqdong
 * @create: 2020-02-21 16:43
 **/

class Runner1 implements Runnable{
  public void run(){
    for (int i = 0; i < 1000; i ++ ){
      System.out.println("这是Runnable接口的Runner1：" + i);
    }
  }
}

public class thread1 {
  public static void main(String[] args){
    Runner1 r1 = new Runner1();
    //r1.run();
    Thread t1 = new Thread(r1);
    t1.start();

    for (int i = 0; i < 1000; i ++ ){
      System.out.println("这是main线程：" + i);
    }

//    这是Runnable接口的Runner1：952
//    这是main线程：986
//    这是Runnable接口的Runner1：953
//    这是main线程：987
//    这是Runnable接口的Runner1：954
//    这是main线程：988
//    这是main线程：989

  }
}
