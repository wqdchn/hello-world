package thread;

/**
 * @program: hello-world
 * @description: 继承Thread类创建和启动线程
 * @author: wqdong
 * @create: 2020-02-21 16:52
 **/

class Runner2 extends Thread {

  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("这是继承Thread的Runner2：" + i);
    }
  }
}

public class thread2 {

  public static void main(String[] args) {
    Runner2 r2 = new Runner2();
    r2.start();

    for (int i = 0; i < 1000; i++) {
      System.out.println("这是main线程：" + i);
    }

//    这是继承Thread的Runner2：51
//    这是main线程：888
//    这是main线程：889
//    这是继承Thread的Runner2：52
//    这是main线程：890
//    这是继承Thread的Runner2：53
//    这是main线程：891
//    这是继承Thread的Runner2：54

  }
}
