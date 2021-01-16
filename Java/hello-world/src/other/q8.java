package other;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: 小易准备去拜访他的朋友，他的家在0点，
 * 但是他的朋友的家在x点(x > 0)，均在一条坐标轴上。
 * 小易每一次可以向前走1，2，3，4或者5步。
 * 问小易最少走多少次可以到达他的朋友的家。
 * @author: wqdong
 * @create: 2020-03-02 12:52
 **/
public class q8 {

  // 这是一个类似最少多少枚硬币凑成一个钱数的问题
  public static int solution(int local) {
    if (local <= 5) {
      return 1;
    }

    int setp = 0;
    int[] setp_length = new int[]{1, 2, 3, 4, 5};
    int[] dp = new int[local + 1];
    Arrays.fill(dp, local + 1);
    dp[0] = 0;

    // 外层循环表示可用的步长组合，
    // 内层循环则表示在当前可用的步长组合下，到达目标位置所需要的步数。
    for (int setp_len : setp_length) {
      for (int i = setp_len; i < local + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i - setp_len] + 1);
      }
    }

    setp = dp[local] != local + 1 ? dp[local] : -1;
    return setp;
  }

}
