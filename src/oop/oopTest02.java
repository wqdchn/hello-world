package oop;

/**
 * @program: hello-world
 * @description: 传值or传引用
 * @author: wqdong
 * @create: 2018-08-25 09:58
 **/
public class oopTest02 {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };
    public static void main(String args[]) {
        oopTest02 ex = new oopTest02();
        //执行了这一句之后
        ex.change(ex.str, ex.ch);
        //ex的str属性没变，但是ch属性被修改了
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
