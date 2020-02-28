package other;

/**
 * @program: hello-world
 * @description: 异或方法，不使用临时变量来交换变量
 * @author: wqdong
 * @create: 2020-02-27 19:43
 **/
public class q6 {

  public static void swap_two_var(int a, int b) {
    System.out.println("输入了a = " + a + "和b = " + b + "，准备交换两个变量");

    a = a ^ b;
    b = b ^ a;
    a = a ^ b;

    System.out.println("交换完成，现在a = " + a + "，b =" + b);
  }

  public static void swap_three_var(int a, int b, int c) {
    System.out.println("输入了a = " + a + "和b = " + b +"和c =" +c +"，准备两两交换");

    a = a ^ b ^c;
    b = b ^ a ^c;
    c = c ^ a ^ b;
    a = a ^ b ^ c;

    System.out.println("交换完成，现在a = " + a + "，b =" + b + ", c = "+ c);
  }

}
