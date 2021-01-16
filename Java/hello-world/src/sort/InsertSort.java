package sort;

import java.util.Random;

/**
 * @program: hello-world
 * @description: 插入排序
 * @author: wqdong
 * @create: 2018-08-25 16:40
 **/
public class InsertSort {

  public static void insertsort(int[] nums) {//O（n^2）

    for (int i = 1; i < nums.length; i++) {
      int temp = nums[i];
      int j = i - 1;
      while (j >= 0 && nums[j] > temp) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = temp;
//      show(nums);
//      System.out.println();
    }
  }

  public static void insertsort_plus1(int[] nums) {//O（n^2）

    for (int i = 1; i < nums.length; i++) {
      for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
        int temp = nums[j];
        nums[j] = nums[j - 1];
        nums[j - 1] = temp;
      }
//      show(nums);
//      System.out.println();
    }
  }

  public static void insertsort_plus2(int[] nums) {//O（n^2）

    for (int i = 1; i < nums.length; i++) {
      int j = i;
      int temp = nums[j];
      for (; j > 0 && nums[j - 1] > temp; j--) {
        nums[j] = nums[j - 1];
      }
      nums[j] = temp;
//      show(nums);
//      System.out.println();
    }
  }

  public static void show(int[] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void main(String[] args) {
//    int[] nums = {2, 3, 1, 5, 4};
    int len = 50000;
    int[] nums = new int[len];
    int[] nums1 = new int[len];
    int[] nums2 = new int[len];

    for (int index = 0; index < nums.length; index++) {
      nums[index] = new Random().nextInt(nums.length) + 1;
    }

    System.arraycopy(nums, 0, nums1, 0, nums.length);
    System.arraycopy(nums, 0, nums2, 0, nums.length);

    System.out.println("#########################");

    long start = System.currentTimeMillis();
    insertsort(nums);//插入排序
    long end = System.currentTimeMillis();
    System.out.println("Runtime: " + (end - start) + "ms");

    System.out.println("#########################");

    start = System.currentTimeMillis();
    insertsort_plus1(nums1);//优化一
    end = System.currentTimeMillis();
    System.out.println("Runtime: " + (end - start) + "ms");

    System.out.println("#########################");

    start = System.currentTimeMillis();
    insertsort_plus2(nums2);//优化二
    end = System.currentTimeMillis();
    System.out.println("Runtime: " + (end - start) + "ms");

//    #########################
//    Runtime: 549ms
//    #########################
//    Runtime: 1018ms
//    #########################
//    Runtime: 531ms
  }
}
