package other;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: 你有3个需要完成的任务，完成这3个任务是需要付出代价的。
 * 首先，你可以不花任何代价的完成一个任务；
 * 然后，在完成了第i个任务之后，你可以花费|Ai - Aj|的代价完成第j个任务。
 * |x|代表x的绝对值。
 * 计算出完成所有任务的最小代价。
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
