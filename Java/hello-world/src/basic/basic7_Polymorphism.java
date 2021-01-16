package basic;

/**
 * @program: hello-world
 * @description: Java基础+多态
 * @author: wqdong
 * @create: 2020-02-21 15:19
 **/

class basic7_Animal {

  private String name;

  basic7_Animal(String name) {
    this.name = name;
  }

  public void enjoy() {
    System.out.println("动物在叫");
  }

}

class basic7_Dog extends basic7_Animal {

  private String color;

  basic7_Dog(String name, String color) {
    super(name);
    color = color;
  }

  public void enjoy() {
    System.out.println("一只狗在叫");
  }

}

class basic7_Cat extends basic7_Animal {

  private String eyecolor;

  basic7_Cat(String name, String eyecolor) {
    super(name);
    eyecolor = eyecolor;
  }

  public void enjoy() {
    System.out.println("一只猫在叫");
  }

}

class basic7_Person {

  private String name;
  private basic7_Animal pet;

  basic7_Person(String name, basic7_Animal pet) {
    this.name = name;
    this.pet = pet;
  }

  public void petenjoy() {
    pet.enjoy();
  }

}


public class basic7_Polymorphism {

  public static void main(String[] args) {
    basic7_Dog d = new basic7_Dog("小白", "白色");
    basic7_Cat c = new basic7_Cat("小灰", "蓝色");
    basic7_Person person1 = new basic7_Person("小明", d);
    basic7_Person person2 = new basic7_Person("小王", c);

    person1.petenjoy();
    person2.petenjoy();

    //一只狗在叫
    //一只猫在叫
  }

}
