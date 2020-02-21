package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: hello-world
 * @description: 一个数组，长度小于1000，要求找出数组内所有素数，去重并升序输出。
 * @author: wqdong
 * @create: 2020-02-21 08:59
 **/
public class q1 {

  public static void main(String[] args) {
    int[] temp1 = new int[1000];
    for (int i = 0; i < 1000; i++) {
      temp1[i] = i;
    }

    int[] temp2 = Arrays.copyOf(temp1, 1000);
    int[] nums = new int[temp1.length + temp2.length];
    System.arraycopy(temp1, 0, nums, 0, 1000);
    System.arraycopy(temp2, 0, nums, 1000, 1000);

    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
      if (i % 25 == 0) {
        System.out.println();
      }
    }

    System.out.println();

    q1_a1(nums);
  }

  public static void q1_a1(int[] nums) {

    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (isPrime(nums[i]) && !set.contains(nums[i])) {
        set.add(nums[i]);
      }
    }

    int size = set.size();
    int[] prime_nums = new int[size];
    Iterator<Integer> it = set.iterator();
    
    for (int i = 0; i < prime_nums.length; i++) {
      prime_nums[i] = it.next();
    }

    Arrays.sort(prime_nums);

    System.out.println("结果如下");

    for (int i = 0; i < prime_nums.length; i++) {
      System.out.print(prime_nums[i] + " ");
      if (i % 10 == 0) {
        System.out.println();
      }
    }

  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
