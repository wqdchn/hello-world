package basic;

/**
 * @program: hello-world
 * @description: String和Integer
 *
 * 栈、常量池、堆，jdk_1.8.0_161
 * @author: wqdong
 * @create: 2019-11-07 14:17
 * @modify: 2020-03-04 14:35
 **/
public class basic1_String_Integer {

  public static void main(String[] arhs) {
    String s1 = new String("12") + new String("34");
    s1.intern();
    String s2 = "1234";
    System.out.println(s1 == s2);// true
    System.out.println(System.identityHashCode(s1));// 1836019240
    System.out.println(System.identityHashCode(s1.intern())); // 1836019240
    System.out.println(System.identityHashCode(s2));// 1836019240

    String s3 = new String("ab") + new String("cd");

    String s4 = "abcd";
    System.out.println(s3 == s4);         // false
    System.out.println(s3.intern() == s4);// true
    System.out.println(s3.equals(s4));    // true
    System.out.println(System.identityHashCode(s3));         // 325040804
    System.out.println(System.identityHashCode(s3.intern()));// 1173230247
    System.out.println(System.identityHashCode(s4));         // 1173230247

    String s5 = new String("1");
    s5.intern();
    String s6 = "1";
    System.out.println(s5 == s6);          // false
    System.out.println(s5.intern() == s6); //true
    System.out.println(System.identityHashCode(s5));          // 856419764
    System.out.println(System.identityHashCode(s5.intern())); // 621009875
    System.out.println(System.identityHashCode(s6));          // 621009875
  }

}
