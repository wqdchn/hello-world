package basic;

/**
 * @program: hello-world
 * @description: String和Integer
 *
 * 栈、常量池、堆，jdk_1.8.0_161
 * @author: wqdong
 * @create: 2019-11-07 14:17
 **/
public class basic1_String_Integer {

  public static void main(String[] arhs) {
    String s1 = new String("你好世界");//堆
    String s2 = s1.intern();//常量池
    String s3 = "你好世界";//常量池

    System.out.println(s1 == s2);//false
    System.out.println(s1 == s3);//false
    System.out.println(s2 == s3);//true

    System.out.println(s1.equals(s3));//true
    System.out.println(s1.equals(s2));//true
    System.out.println(s2.equals(s3));//true

    String s6 = new String("1") + new String("1");
    s6.intern();
    String s7 = "11";
    System.out.println(s6 == s7);//true

//  String类里面是这样重写equals()方法的实现的：
//  用当前的这个字符串对象和指定的字符串对象比较，
//  指定的字符串对象不能为空并且这个对象的字符序列和当前这个字符串对象的字符串序列一样，
//  如果这些条件都满足，那么这两个字符串对象就是相等的。

    s1 = "你好";
    s2 = "世界";

    s3 = "你好" + "世界";//常量池
    String s4 = s1 + s2;//堆
    String s5 = "你好世界";//常量池

    System.out.println(s3 == s4);//false
    System.out.println(s3 == s5);//true
    System.out.println(s4 == s5);//false

    System.out.println(s4.equals(s3));//true
    System.out.println(new String("你好世界").equals(s3));//true

    System.out.println();

    Integer i1 = 127;//常量池
    Integer i2 = 127;//常量池
    Integer i3 = 0;//常量池

    Integer i4 = new Integer(127);//堆
    Integer i5 = new Integer(127);//堆
    Integer i6 = new Integer(0);//堆

    Integer i7 = 128;
    Integer i8 = 128;
    Integer i9 = new Integer(128);
    Integer i10 = new Integer(128);

    System.out.println(i1 == i2);//true
    System.out.println(i1 == i2 + i3);//true
    System.out.println(i1 == i4);//false
    System.out.println(i4 == i5);//false
    System.out.println(i4 == i5 + i6);//true
    System.out.println(i4.intValue() == i5.intValue() + i6.intValue());//true
    System.out.println(127 == i5 + i6);//true

    System.out.println(i7 == i9);//false
    System.out.println(i8 == i10);//false

    System.out.println(i7 == i8);//false
    System.out.println(i9 == i10);//false
  }

}
