package other;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: ����3����Ҫ��ɵ����������3����������Ҫ�������۵ġ�
 * ���ȣ�����Բ����κδ��۵����һ������
 * Ȼ��������˵�i������֮������Ի���|Ai - Aj|�Ĵ�����ɵ�j������
 * |x|����x�ľ���ֵ��
 * �������������������С���ۡ�
 * @author: wqdong
 * @create: 2020-03-02 12:45
 **/
public class q7 {

  public static int solution(int[] nums) {
    Arrays.sort(nums);
    int cost = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      cost += nums[i + 1] - nums[i];
    }

    return cost;
  }

}
