package lambda;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: lamba
 * @author: wqdong
 * @create: 2018-08-27 17:23
 **/
public class lambaTest01 {

    public static void main(String[] args){
        String[] p = new String[] {"max","good","as","backup","look"};
        System.out.println(Arrays.toString(p));
        Arrays.sort(p,(String a,String b) -> a.length() - b.length());
        System.out.println(Arrays.toString(p));

    }
}
