package other;

import java.util.Arrays;

/**
 * @program: hello-world
 * @description: 合并两个无序数组，使其有序
 * @author: wqdong
 * @create: 2020-03-04 16:05
 **/
public class q9 {

  public static int[] sortTwoNonSortArray(int[] a, int[] b) {

    int[] result = new int[a.length + b.length];
    int k = 0;

    for (int i = 0; i < a.length; i++) {
      result[k] = a[i];
      k++;
    }

    for (int i = 0; i < b.length; i++) {
      result[k] = b[i];
      k++;
    }

    //Arrays.sort(result);
    qSort(result, 0, result.length - 1);
    return result;
  }

  public static void qSort(int[] nums, int start, int end) {
    if (start >= end || nums.length <= 1) {
      return;
    }
    int low = start;
    int high = end;
    int mid = (low + high) / 2;

    while (low <= high) {

      while (nums[low] < nums[mid]) {
        low++;
      }
      while (nums[high] > nums[mid]) {
        high--;
      }

      if (low < high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;

        low++;
        high--;
      } else if (low == high) {
        low++;
      }

      qSort(nums, start, high);
      qSort(nums, low, end);

    }

  }

}
