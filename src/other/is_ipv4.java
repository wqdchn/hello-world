package other;

/**
 * @program: hello-world
 * @description: 检查字符串是不是IPv4地址
 * @author: wqdong
 * @create: 2020-03-06 19:18
 **/
public class is_ipv4 {

  public static boolean is_ipv4(String str) {

    if (str == null || str.length() < 7 || str.length() > 15) {
      return false;
    }

    String[] str_arr = str.split("\\.");
    if (str_arr.length != 4) {
      return false;
    }

    for (String s : str_arr) {
      if (s.length() > 3 || "".equals(s) || (s.charAt(0) == '0' && s.length() > 1)) {
        return false;
      }

      for (int i = 0; i < s.length(); i++) {
        if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
          return false;
        }
      }

      if (Integer.parseInt(s) > 255) {
        return false;
      }
    }

    return true;
  }
}
