package other;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: С��׼��ȥ�ݷ��������ѣ����ļ���0�㣬
 * �����������ѵļ���x��(x > 0)������һ���������ϡ�
 * С��ÿһ�ο�����ǰ��1��2��3��4����5����
 * ��С�������߶��ٴο��Ե����������ѵļҡ�
 * @author: wqdong
 * @create: 2020-03-02 12:52
 **/
public class q8 {

  // ����һ���������ٶ���öӲ�Ҵճ�һ��Ǯ��������
  public static int solution(int local) {
    if (local <= 5) {
      return 1;
    }

    int setp = 0;
    int[] setp_length = new int[]{1, 2, 3, 4, 5};
    int[] dp = new int[local + 1];
    Arrays.fill(dp, local + 1);
    dp[0] = 0;

    // ���ѭ����ʾ���õĲ�����ϣ�
    // �ڲ�ѭ�����ʾ�ڵ�ǰ���õĲ�������£�����Ŀ��λ������Ҫ�Ĳ�����
    for (int setp_len : setp_length) {
      for (int i = setp_len; i < local + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i - setp_len] + 1);
      }
    }

    setp = dp[local] != local + 1 ? dp[local] : -1;
    return setp;
  }

}
