package basic;

/**
 * @program: hello-world
 * @description: Java基础：抽象类
 * @author: wqdong
 * @create: 2020-02-21 14:23
 **/

abstract class Animal {

  private String name;

  Animal(String name) {
    this.name = name;
  }

  public abstract void eat();
}

class Dog extends Animal {

  private String Dog_Color;

  Dog(String name, String color) {
    super(name);
    Dog_Color = color;
  }

  public void eat() {
    System.out.println("一只" + Dog_Color + "的狗正在啃骨头");
  }

}

class GreyDog extends Dog {

  public GreyDog(String name, String color) {
    super(name, color);
  }

  public void eat() {
    System.out.println("一只灰色的狗正在啃骨头");
  }

  public void run() {
    System.out.println("一只灰色的狗正在乱跑");
  }

}

public class basic5_Abstract {

  public static void main(String[] args) {
    Dog dog = new Dog("小白", "白色");
    dog.eat();

    GreyDog gdog = new GreyDog("小灰", "灰色");
    gdog.eat();
    gdog.run();
  }


}
