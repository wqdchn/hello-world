package other;

/**
 * @program: hello-world
 * @description: 连续最大子段和
 * @author: wqdong
 * @create: 2020-02-26 20:23
 **/
public class q4 {

  public static int FindGreatestSumOfSubArray(int[] nums) {

    int maxsum = 0;
    int currsum = 0;

    for (int i = 0; i < nums.length; i++) {
      currsum += nums[i];
      if (currsum > maxsum) {
        maxsum = currsum;
      }
      if (currsum < 0) {
        currsum = 0;
      }
    }

    return maxsum;
  }

}
