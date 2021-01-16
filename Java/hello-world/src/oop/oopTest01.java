package oop;

/**
 * @program: hello-world
 * @description: 类&静态
 * @author: wqdong
 * @create: 2018-08-24 17:18
 **/
class A{
    private  static int i = 10086;
    private  int j;
    public double p = 3.14;
    public void fun1 (){
        j=i;
        i++;
        System.out.println("i ="+i+"j ="+j);
    }

    public String toString(){
        return getClass().getName()+
                "[i ="+i+"p= "+p+"]";
    }
}

class B{
    private  int i = 10086;
    private  int j;
    public static final double p =3.14;
    public void fun1 (){
        j=i;
        i++;
        System.out.println("i ="+i+"j ="+j);
    }

}

public class oopTest01 {
    public static void main(String[] args){

        A a1 = new A();
        A a2 = new A();
        a1.fun1();
        a2.fun1();
        System.out.println(a1.p*=2);
        System.out.println(a1.p);
        System.out.println(a1.toString());

        B b1 = new B();
        B b2 = new B();
        b1.fun1();
        b2.fun1();
        System.out.println(b1.p);
    }
}
