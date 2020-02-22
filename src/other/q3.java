package other;

/**
 * @program: hello-world
 * @description: 计数排序问题
 * @author: wqdong
 * @create: 2020-02-22 14:30
 **/
public class q3 {

  public static void main(String[] args) {
    int length = 1000;
    int[] nums = new int[length];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) (Math.random() * 100);
    }

    nums = countSort(nums);

    System.out.println();

    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
      if (i % 50 == 0) {
        System.out.println();
      }
    }

  }

  public static int[] countSort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }

    int[] help = new int[max - min + 1];

    for (int i = 0; i < nums.length; i++) {
      int poscount = nums[i] - min;
      help[poscount]++;
    }

    int index = 0;
    for (int i = 0; i < help.length; i++) {
      while (help[i]-- > 0) {
        nums[index++] = i + min;
      }
    }

    return nums;
  }
}
