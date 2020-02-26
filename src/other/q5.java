package other;

/**
 * @program: hello-world
 * @description: ÄæĞòÊä³ö×Ö·û´®
 * @author: wqdong
 * @create: 2020-02-26 20:38
 **/
public class q5 {

  public static String reverseString(String str) {
    char[] chars = str.toCharArray();
    char[] rechars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      rechars[i] = chars[chars.length - i - 1];
    }

    return String.valueOf(rechars);
  }

  public static String reverseString2(String str){
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }

}
