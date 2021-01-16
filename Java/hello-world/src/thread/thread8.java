package thread;

/**
 * @program: hello-world
 * @description: 生产者消费者问题
 * @author: wqdong
 * @create: 2020-02-22 08:58
 **/
public class thread8 {

  public static void main(String[] args) {
    SyncStack stack = new SyncStack();

    Runnable producer = new Producer(stack);
    Runnable consumer = new Consumer(stack);

    Thread p = new Thread(producer);
    Thread c = new Thread(consumer);

    p.start();
    c.start();

  }

}

class SyncStack {

  private int index = 0;
  private char[] data = new char[20];

  public synchronized void push(char c) {
    if (index == data.length) {
      try {
        this.wait(500);
      } catch (InterruptedException e) {
      }
    }

    this.notify();
    data[index] = c;
    index++;
  }

  public synchronized char pop() {
    if (index == 0) {
      try {
        this.wait(500);
      } catch (InterruptedException e) {
      }
    }

    this.notify();
    index--;
    return data[index];
  }
}


class Producer implements Runnable {

  SyncStack stack;

  public Producer(SyncStack s) {
    stack = s;
  }

  public void run() {
    for (int i = 0; i < 20; i++) {
      char c = (char) (Math.random() * 26 + 'A');
      stack.push(c);
      System.out.println("生产了" + c);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

class Consumer implements Runnable {

  SyncStack stack;

  public Consumer(SyncStack s) {
    stack = s;
  }

  public void run() {
    for (int i = 0; i < 20; i++) {
      char c = stack.pop();
      System.out.println("消费了" + c);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}



