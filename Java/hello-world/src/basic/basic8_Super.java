package basic;

/**
 * @program: hello-world
 * @description: Java基础+super关键字
 * @author: wqdong
 * @create: 2020-02-21 16:00
 **/

class basic8_father {

  public int value;

  public void fun() {
    value = 100;
    System.out.println("父类的value值是" + value);
  }
}

class basic8_child extends basic8_father {

  public int value;

  public void fun() {
    super.fun();
    value = 200;
    System.out.println("子类的value值是" + value);

    System.out.println(value);
    System.out.println(super.value);
  }
}

public class basic8_Super {

  public static void main(String[] args) {
    basic8_child child = new basic8_child();
    child.fun();
  }

}
