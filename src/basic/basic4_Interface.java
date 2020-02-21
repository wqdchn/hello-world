package basic;

import javax.swing.text.Style;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @program: hello-world
 * @description: Java基础：接口
 * @author: wqdong
 * @create: 2020-02-21 13:55
 **/

interface Painter {

  public void eat();

  public void speak();
}

interface Singer {

  public void sing();

  public void sleep();
}

class Student implements Singer {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName() {
    this.name = name;
  }

  // 实现Singer接口的sing方法

  public void sing() {
    System.out.println("学生" + name + "正在唱歌");
  }

  // 实现Singer接口的sleep方法

  public void sleep() {
    System.out.println("学生" + name + "正在睡觉");
  }

  //自己的方法

  public void study() {
    System.out.println("学生" + name + "正在学习");
  }

}

class Teacher implements Singer, Painter {

  private String name;

  public Teacher(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName() {
    this.name = name;
  }

  // 实现Singer接口的sing方法

  public void sing() {
    System.out.println("老师" + name + "正在唱歌");
  }

  // 实现Singer接口的sleep方法

  public void sleep() {
    System.out.println("老师" + name + "正在睡觉");
  }

  // 实现Painter接口的eat方法

  public void eat() {
    System.out.println("老师" + name + "正在吃火锅");
  }

  // 实现Painter接口的speakt方法

  public void speak() {
    System.out.println("老师" + name + "正在演讲");
  }

  // 自己的方法

  public void teach() {
    System.out.println("老师" + name + "正在讲课");
  }

}

public class basic4_Interface {

  public static void main(String[] args) {
    Singer s1 = new Student("小明");
    s1.sing();
    s1.sleep();

    Singer s2 = new Teacher("李白");
    s2.sing();
    s2.sleep();
    ((Teacher) s2).speak();

    Painter p1 = new Teacher("杜甫");
    p1.eat();
    p1.speak();
    ((Teacher) p1).sing();

//    学生小明正在唱歌
//    学生小明正在睡觉
//    老师李白正在唱歌
//    老师李白正在睡觉
//    老师李白正在演讲
//    老师杜甫正在吃火锅
//    老师杜甫正在演讲
//    老师杜甫正在唱歌
  }

}
