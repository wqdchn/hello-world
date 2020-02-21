package basic;

/**
 * @program: hello-world
 * @description: Java基础：对象转型
 * @author: wqdong
 * @create: 2020-02-21 14:47
 **/

class myAnimal {

  public String name;

  public myAnimal(String name) {
    this.name = name;
  }
}

class myDog extends myAnimal {

  public String color;

  public myDog(String name, String color) {
    super(name);
    this.color = color;
  }
}

class myCat extends myAnimal {

  public String eyecolor;

  public myCat(String name, String eyecolor) {
    super(name);
    this.eyecolor = eyecolor;
  }

}

public class basic_Casting {

  public static void main(String[] args) {
    myAnimal animal = new myAnimal("动物");
    myDog dog = new myDog("狗", "白色");
    myCat cat = new myCat("猫", "蓝色");

    //true
    System.out
        .println(String.format("animal instanceof myAnimal的结果是%s", animal instanceof myAnimal));

    //true
    System.out.println(String.format("dog instanceof myAnimal的结果是%s", dog instanceof myAnimal));
    System.out.println(String.format("cat instanceof myAnimal的结果是%s", cat instanceof myAnimal));

    //false
    System.out.println(String.format("animal instanceof myDog的结果是%s", animal instanceof myDog));

    animal = new myDog("新的狗", "灰色");
    System.out.println(animal.name);

    // 父类引用指向子类对象的时候，它看到的只是作为父类的那部分所拥有的属性和方法，
    // 至于作为子类的那部分它没有看到
    System.out.println(((myDog) animal).color);

    //true
    System.out.println(String.format("animal instanceof mydog%s", animal instanceof myDog));
    //true
    System.out
        .println(String.format("animal instanceof myAnimal的结果是%s", animal instanceof myAnimal));

    myDog dog2 = (myDog) animal;
    System.out.println(dog2.name);
    System.out.println(dog2.color);

  }

}
